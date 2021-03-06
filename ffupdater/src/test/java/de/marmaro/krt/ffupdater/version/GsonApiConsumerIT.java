package de.marmaro.krt.ffupdater.version;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

/**
 * Check if a specific app can be downloaded by the devices only running the minimum API Level for the app.
 * Some website like GitHub doesn't support TLSv1 anymore.
 *
 * | App             | min API | min TLS by min API | source                             |
 * |-----------------|---------|--------------------|------------------------------------|
 * | FIREFOX_FOCUS   | 21      | TLSv1.2            | firefox-ci-tc.services.mozilla.com |
 * | FIREFOX_KLAR    | 21      | TLSv1.2            | firefox-ci-tc.services.mozilla.com |
 * | FIREFOX_LITE    | 21      | TLSv1.2            | api.github.com                     |
 * | FIREFOX_RELEASE | 21      | TLSv1.2            | firefox-ci-tc.services.mozilla.com |
 * | FIREFOX_BETA    | 21      | TLSv1.2            | firefox-ci-tc.services.mozilla.com |
 * | FIREFOX_NIGHTLY | 21      | TLSv1.2            | firefox-ci-tc.services.mozilla.com |
 * | LOCKWISE        | 24      | TLSv1.2            | api.github.com                     |
 *
 * Results:
 * | source                             | required TLS |
 * |------------------------------------|--------------|
 * | api.github.com                     | TLSv1.2      |
 * | firefox-ci-tc.services.mozilla.com | TLSv1.2      |
 *
 */
public class GsonApiConsumerIT {
    private static final String SSL_3 = "SSLv3";
    private static final String TLS_1_2 = "TLSv1.2";
    public static final String GITHUB_URL = "https://api.github.com/repos/mozilla-tw/FirefoxLite/releases/latest";
    public static final String MOZILLA_CI_API = "https://firefox-ci-tc.services.mozilla.com/api/index/v1/task/mobile.v2.fenix.fennec-production.latest.arm64-v8a/artifacts/public/chain-of-trust.json";

    @Test
    public void githubApi_TSLv12_noException() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        checkConnection(TLS_1_2, GITHUB_URL);
    }

    @Test
    public void mozillaCIServer_TSLv12_noException() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        checkConnection(TLS_1_2, MOZILLA_CI_API);
    }

    // validate if the TLS-version check works by using an outdated TLS-version:

    @Test(expected = SSLHandshakeException.class)
    public void githubApi_SSLv3_SSLHandshakeException() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        checkConnection(SSL_3, GITHUB_URL);
    }

    @Test(expected = SSLHandshakeException.class)
    public void mozillaCIServer_SSLv3_SSLHandshakeException() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        checkConnection(SSL_3, MOZILLA_CI_API);
    }

    private void checkConnection(String protocol, String url) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        HttpsURLConnection urlConnection = (HttpsURLConnection) new URL(url).openConnection();
        try {
            urlConnection.setSSLSocketFactory(new CustomSocketFactory(new String[]{protocol}));
            urlConnection.setRequestMethod("HEAD");
            urlConnection.getInputStream();
        } finally {
            urlConnection.disconnect();
        }
    }
}