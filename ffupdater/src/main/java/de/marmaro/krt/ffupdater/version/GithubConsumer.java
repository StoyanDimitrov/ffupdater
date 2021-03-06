package de.marmaro.krt.ffupdater.version;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Access the version name and the download url from Github.
 */
class GithubConsumer {
    private static final String LATEST_RELEASE_URL = "https://api.github.com/repos/%s/%s/releases/latest";
    private static final String ALL_RELEASES_URL = "https://api.github.com/repos/%s/%s/releases";

    @Nullable
    static Release findLatestRelease(String owner, String repo) {
        Release release = findLatestReleaseByApi(owner, repo);
        if (release != null && release.getAssets() != null && !release.getAssets().isEmpty()) {
            return release;
        }
        return findLatestReleaseBySearchingAllReleases(owner, repo);
    }

    @Nullable
    private static Release findLatestReleaseByApi(String owner, String repo) {
        String downloadUrl = String.format(LATEST_RELEASE_URL, owner, repo);
        return ApiConsumer.consume(downloadUrl, Release.class);
    }

    @Nullable
    private static Release findLatestReleaseBySearchingAllReleases(String owner, String repo) {
        String downloadUrl = String.format(ALL_RELEASES_URL, owner, repo);
        Release[] releases = ApiConsumer.consume(downloadUrl, Release[].class);
        if (releases == null) {
            return null;
        }

        for (Release release : releases) {
            if (release.getAssets() != null && !release.getAssets().isEmpty()) {
                return release;
            }
        }
        return null;
    }

    static class Asset {
        @SerializedName("name")
        private String name;

        @SerializedName("browser_download_url")
        private String downloadUrl;

        public String getName() {
            return name;
        }

        String getDownloadUrl() {
            return downloadUrl;
        }

        @NonNull
        @Override
        public String toString() {
            return "Asset{" +
                    "name='" + name + '\'' +
                    ", downloadUrl='" + downloadUrl + '\'' +
                    '}';
        }
    }

    static class Release {
        @SerializedName("tag_name")
        private String tagName;

        @SerializedName("assets")
        private List<Asset> assets;

        String getTagName() {
            return tagName;
        }

        List<Asset> getAssets() {
            return assets;
        }

        @NonNull
        @Override
        public String toString() {
            return "Release{" +
                    "tagName='" + tagName + '\'' +
                    ", assets=" + assets +
                    '}';
        }
    }
}
