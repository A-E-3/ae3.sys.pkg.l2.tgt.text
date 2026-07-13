# CLAUDE.md — ae3.sys.pkg.l2.tgt.text

AE3 L2 media target for plain-text output. Simplest of the `l2.tgt.*` targets touched this session — abstract layout/context-handler shape, no bundled JS/skin resources or third-party libraries.

## Structure

- `java/ru/myx/ae3/l2/text/`
  - `TextTargetContext extends TargetContextAbstract<TextTargetContext>` (abstract) — the base target-context.
  - `TextFileTargetContext extends TextTargetContext` — file-output variant.
  - `TextContextHandler extends ContextHandler<TextTargetContext, BaseObject>` — context-handler interface.
  - `TextLayoutDefinition` (package-private, abstract) `implements LayoutDefinitionAbstract<TextTargetContext>, TextContextHandler` — base for the layout definitions below.
  - `TextLayoutSequence`, `TextLayoutString` (both package-private) `extends TextLayoutDefinition` — the only two registered layouts (no grid/image/link/etc. variants like the HTML/XHTML families have).
  - `TestText.java` — manual smoke-test entry point, same shape as this family's other `Test*` classes.

## Build

- Requires (Java, confirmed by source imports): `ae3.sdk` only — every cross-package import resolves to `ru.myx.ae3.i3.TargetInterface` (`ae3.api`) or `ru.myx.ae3.l2.*`/`ru.myx.ae3.Engine`/`ru.myx.ae3.report.Report`/`ru.myx.ae3.binary.*` (`ae3.sdk`).
- No `package.json` at all under `ae3-packages/` (unlike the other `l2.tgt.*` units touched this session) — the bundle folder itself is still named `ae3.sys.l2.tgt.text`, which is the only naming signal available here (weaker corroboration than a `package.json` `"name"` field, but consistent with the pattern seen everywhere else: `ae3.sys.pkg.l2.tgt.<X>` directory -> `ae3.sys.l2.tgt.<X>` bundle/Provides name).

## Gotchas

- **This unit had no `.gitignore`/`.project`/`.classpath`/`project.inf` at all** when checked out this session — all four added fresh, modeled on `ae3.sys.pkg.l2.tgt.html`'s versions.
- **8 compiled `.class` files are checked into git under `bin/`** — not yet cleaned up (same pre-existing hygiene issue as the other `l2.tgt.*` units touched this session).
- See `ae3.sys.pkg.l2.tgt.html`'s CLAUDE.md for the broader discussion of why `l2.tgt.xml`'s three-entry `Provides:` shape isn't treated as a confirmed convention here.
