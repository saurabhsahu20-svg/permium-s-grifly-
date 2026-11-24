# Grifly Premium

Version 2.0.4-beta (versionCode 29). Build with GitHub Actions.

## In-place updates

The package stays `com.saurabhsvision.sbrowser`. Keep the existing storage schema and increase versionCode for each release. A permanent private signing key is essential. The newly generated key establishes a new signing baseline, which cannot replace a differently signed legacy APK in place. Configure these GitHub Actions repository secrets using the original owner-controlled key:

- GRIFLY_SIGNING_KEYSTORE_BASE64
- GRIFLY_SIGNING_STORE_PASSWORD
- GRIFLY_SIGNING_KEY_ALIAS
- GRIFLY_SIGNING_KEY_PASSWORD

Never commit the private key or passwords. The default expected certificate SHA-256 is the new permanent Grifly public certificate fingerprint: `7950d7c6bb15da8a44a05421849527213b1822c12e64f49155f048e286cc3e3b`. Configure the corresponding new key in repository secrets. For legacy signing, only explicitly set `GRIFLY_ORIGINAL_CERT_SHA256` when the verified legacy key is available. Different signing identities cannot normally update each other.

With no signing credentials, Actions builds a TEST_ONLY artifact, not a public update. A certificate-matched APK must pass the regression tests and package/version checks before it is published to Releases. Never replace a previously published version. The update checker in v2.0.3 points to this repository. Older app builds may require one manual compatible update before they use the new update source.

## Changes

Minimal home remains; System/Light/Dark home appearance, restore previous tabs, latest download status and failed-download retry, stronger HTTPS navigation, page-load feedback, improved update checking, normalized news deduplication. Android DownloadManager handles automatic pause/resume; manual pause/resume and full-app theme coverage are not implemented. Vision online resources retain their existing live links; the bundled paper catalog remains pinned.

Physical-device testing and upgrade verification remain required before production use.

## 2.0.3 performance and reliability

Restore saved tabs without loading all pages concurrently; background tabs load only when selected. Validate URL hosts, ports and credentials; upgrade HTTP addresses to HTTPS; avoid repeated history writes; close and clear live tabs when clearing browsing data. Secure URL regression coverage added. Twelve pure-Java regression test programs passed locally on the base source and updated address/news modules. Full Android build and on-device startup, scrolling, RAM and network latency remain unverified. YouTube channel integration added to Student Dashboard and More menu: https://www.youtube.com/@saurabhsvision.
