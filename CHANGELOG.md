# 2020-10-?? Version 69.0.6 (54)
 * Fix short description in F-Droid - thanks linsui

# 2020-09-23 Version 69.0.5 (53)
 * Disable error when the already installed app has a different signature (because Android won't install an update with a different signature) - thanks pheki for reporting this bug
 * Add translations for this bug
 * Make the installation activity a little big more resilient

# 2020-09-08 Version 69.0.4 (52)
 * Fix old download urls / update check urls for Firefox Release and Firefox Beta - thanks DctrBnsttr for reporting this bug
 * Add tests to ensure that FFUpdater is always using the latest download urls

# 2020-08-17 Version 69.0.3 (51)
 * Fix broken Firefox Nightly installation/update - thanks 132ikl for reporting this bug

# 2020-08-13 Version 69.0.2 (50)
 * Thanks aevw for adding brazilian portuguese translation

# 2020-08-12 Version 69.0.1 (49)
 * Thanks DeenHyper74 for updating the russian translation

# 2020-08-05 Version 69.0.0 (48)
 * Remove Fennec Release because it's no longer supported by Mozilla
 * Rename Fenix Release, Fenix Beta and Fenix Nightly to Firefox Release, Firefox Beta, Firefox Nightly
 * Fix download URLs for Firefox Release, Firefox Beta, Firefox Nightly
 * Use the more reliable PackageInstaller-method for installing the apps (instead of the old ACTION_INSTALL_PACKAGE-method)
 * Increase minimum SDK for FFUpdater to Lollipop/21 (because PackageInstaller needs 21 and all Firefox browsers need at least 21)
 * Fix bug "empty installed text field"
 * Thanks trymeout, guysoft, rantpalas and RomainL972 for reporting bugs

# 2020-07-02 Version 68.4.1 (47)
 * Fix broken Fenix download - if the download is still broken for you, wait 10 minutes or delete the storage of the app
 * Check for enough free space and display warning if < 100MB

# 2020-06-07 Version 68.4.0 (46)
 * Add Fenix Beta, Fenix Nightly and Lockwise
 * Download Fenix Release/Beta/Nightly, Focus and Klar from Mozilla's Taskcluster (continuous integration server)
 * Fix "Light theme is always shown at first run"
 * Thanks Rail Aliiev and Johan Lorenzo from Mozilla for their support <https://bugzilla.mozilla.org/show_bug.cgi?id=1627518>
 * Thanks KarlHeinz and DeenHyper74 for their error reporting and support

# 2020-05-20 Version 68.3.7 (42)
 * Add simple crash reporter (by opening the mail app with the error message)
 * Fix crash by asking for WRITE_EXTERNAL_STORAGE and READ_EXTERNAL_STORAGE permissions
 * Show progress bar when verifying the downloaded APK
 * Download APK to the public download directory of the app (for example: /storage/sdcard0/Android/data/de.marmaro.krt.ffupdater/files/Download)
 * Remove old debug messages
 * Thanks yhoyhoj, UltraBlackLinux, rvandegrift, vikajon, wchen342, Ulfschaper, prox and danceswithcats for your error reporting

# 2020-05-18 Version 68.3 (35)
 * Try to fix error "Failed to check certificate hash" by switching from apksig-library to PackageManager#getPackageArchiveInfo (thanks rvandegrift). This will reduce the size of FFUpdater and improve the maintenance for future releases.
 * Color of collapsed title will be always white (thanks DeenHyper74)

# 2020-05-13 Version 68.2 (34)
 * Fix Fenix download from Github (thanks yhoyhoj)
 * Show correct download progress when downloading an app

# 2020-05-13 Version 68.1 (33)
 * Thanks DeenHyper74 for the Russian translation
 * Add support for Dark Theme (thanks DeenHyper74 for the tip)
 * Add setting for switching between Dark and Light Theme

# 2020-05-06 Version 68.0 (32)
 * Really big update
 * Add support for Firefox Klar, Firefox Focus, Firefox Lite and Fenix
 * Download and install the app inside FFUpdater (thanks wolfgang42 for the groundwork)
 * Improve UI
 * Verify the certificate of the downloaded and installed app
 * Many improvements
 * Thanks DeenHyper74 and xin for translations
 * Remove Fennec Beta and Fennec Nightly because their are not developed anymore https://bugzilla.mozilla.org/show_bug.cgi?id=1627518

# 2019-06-28 Version 67.4 (31)
 * Fix warning dialogue disappears after screen rotation (thanks DeenHyper74)

# 2019-06-28 Version 67.3 (30)
 * Fix crash when selecting an entry after rotating the channel dialog (thanks DeenHyper74)

# 2019-06-28 Version 67.2 (29)
 * Fix crash when rotating on channel dialog (thanks DeenHyper74)

# 2019-06-28 Version 67.1 (28)
 * Update Russian translation (thanks DeenHyper74)

# 2019-06-28 Version 67.0 (27)
 * Fix broken nightly download (thanks dannycolin for the info)
 * Display warning when switching from 'Release' channel to the 'Nightly' or 'Beta' channel (thanks DeenHyper74)
 * Interval between update checks is now configurable (thanks aplufr, wah6Me1l and DeenHyper74)

# 2019-04-25 Version 66.2 (26)
 * Improve french translation (thanks xinxinxinxinxin)
 * Fix "update notification will be shown every 5 minutes" (bug discovered by aplufr)

# 2019-04-25 Version 66.1 (25)
 * Add grammar fixes (thanks DeenHyper74)

# 2019-04-25 Version 66.0 (24)
 * Notification (for a Firefox update) now works on Android 9
 * Replace BackgroundService with WorkManager (AndroidX) for requesting Mozilla's API
 * Clean up code (thanks DeenHyper74)
 * Fix some minor bugs (thanks DeenHyper74)
 * App requires API level 18 because Firefox requires API level 18
 * Update translation

# 2019-04-01 Version 65.0 (23)
 * Added support for beta and nightly channels
 * Switched to light theme
 * Update russian translation
 * Handover maintainership to https://notabug.org/Tobiwan/ffupdater

# 2018-01-07 Version 57.0 (22)
 * Add some translations

# 2017-06-13 Version 54.0 (21)
 * Add license report
 * Update icon
 * Add some translations

# 2017-05-20 Version 53.0 (20)
 * Update to 53.0
 * Use new Mozilla API to det version information
 * Remove a lot of unused code.
 * Add icon
 * Fix crash with SDK < 17
 * Enable smaller builds

# 2017-01-22 Version 51.0 (18)
 * Update to 51.0
 * Remove a lot of unused code.
 * Re-implement actual checking.

# 2016-04-29 Version 46.0 (16)
 * No changes, just bump to remind people

# 2016-04-06 Version 45.0.1 (15)
 * Remove everything but URL generator and download button.

# 2016-03-09 Version 45.0a (14)
 * Really, really quickfix Android6 issues..
 * Remove version check since it's broken: Just download the APK.

# 2016-03-06 Version 45.0 (13)
 * Use lower target to quickfix Android6 permissions

# 2016-01-26 Version 44.0 (12)
 * Update to reflect new Firefox version, but no change in
   architecture. Mozilla "-latest" URL still works...

# 2015-12-31 Version 43.0.x (11)
 * Mozilla removed /latest/* downloads from archive. As recommended in
   https://archive.mozilla.org/pub/mobile/releases/latest/README.txt
   we use https://download.mozilla.org/?product=fennec-latest now.

# 2015-12-25 Version 43.0 (10)
 * Update to 43.0
 * Mozilla does not populate /latest/ anymore, see
   https://bugzilla.mozilla.org/show_bug.cgi?id=1233399

# 2015-12-24 Version 42.0.2 (9)
 * Update to 42.0.2

# 2015-11-23 Version 42.0.1 (8)
 * Update to 42.0.1

# 2015-11-02 Version 42.0 (7)
 * Update to 42.0

# 2015-09-23 Version 41.0 (6)
 * Bump to 41.0 (6)

# 2015-09-01 Version 40.0.3 (5)
 * Mark background setting as non-functional for now.
 * Update to 40.0.3

# 2015-08-10 Version 40.0 (3)
 * Remove FTP lookup since Mozilla is shutting down the servers.
 * Handle both request type by a single button.
 * "I am feeling lucky" now gets the next release, not the latest.
 * Add preferences to restrict connections: WiFi-only, metered, roaming.
 * Use actionbar.

# 2015-07-08 Version 39.0 (1)
 * Select download uri based on arch and api.
 * Check filename via FTP.
 * Download update file via HTTPS and DownloadManager.
 * Log errors and status.
 * Toast on updates.
 * Prompt for update (if necessary).
 * Option to use fixed/tested download location.
 * Add proper LICENSE (GPLv3+).