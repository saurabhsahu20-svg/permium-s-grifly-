# Grifly Premium

Version 2.0.2-beta (versionCode 27). Build with GitHub Actions.

## In-place updates

The package stays `com.saurabhsvision.sbrowser`. Keep the existing storage schema and increase versionCode for each release. The original private signing key is essential. Configure these GitHub Actions repository secrets using the original owner-controlled key:

- GRIFLY_SIGNING_KEYSTORE_BASE64
- GRIFLY_SIGNING_STORE_PASSWORD
- GRIFLY_SIGNING_KEY_ALIAS
- GRIFLY_SIGNING_KEY_PASSWORD

Never commit the private key or passwords. The default expected certificate SHA-256 is the public fingerprint extracted from the supplied v1.9.4 APK: `91f95330c0ee850001446a7a31e0537d81a7b481fc78a1f681c0eb2477acca71`. Confirm this against the actual installed APK; if the installed build differs, the owner must configure the verified fingerprint using repository variable `GRIFLY_ORIGINAL_CERT_SHA256` and its corresponding original key. Different signing identities cannot normally update each other.

With no signing credentials, Actions builds a TEST_ONLY artifact, not a public update. A certificate-matched APK must pass the regression tests and package/version checks before it is published to Releases. Never replace a previously published version. The update checker in v2.0.2 points to this repository. Older app builds may require one manual compatible update before they use the new update source.

## Changes

Minimal home remains; System/Light/Dark home appearance, restore previous tabs, latest download status and failed-download retry, stronger HTTPS navigation, page-load feedback, improved update checking, normalized news deduplication. Android DownloadManager handles automatic pause/resume; manual pause/resume and full-app theme coverage are not implemented. Vision online resources retain their existing live links; the bundled paper catalog remains pinned.

Physical-device testing and upgrade verification remain required before production use.
