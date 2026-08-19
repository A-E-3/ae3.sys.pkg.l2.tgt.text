# CLAUDE.md — ae3.sys.pkg.l2.tgt.text

AE3 L2 media target for plain-text output. Simplest of the `l2.tgt.*` targets — abstract layout/context-handler shape, no bundled JS/skin resources or third-party libraries.

## Structure

- `java/ru/myx/ae3/l2/text/`
  - `TextTargetContext extends TargetContextAbstract<TextTargetContext>` (abstract) — the base target-context.
  - `TextFileTargetContext extends TextTargetContext` — file-output variant.
  - `TextContextHandler extends ContextHandler<TextTargetContext, BaseObject>` — context-handler interface.
  - `TextLayoutDefinition` (package-private, abstract) `implements LayoutDefinitionAbstract<TextTargetContext>, TextContextHandler` — base for the layout definitions below.
  - `TextLayoutSequence`, `TextLayoutString` (both package-private) `extends TextLayoutDefinition` — the only two registered layouts (no grid/image/link/etc. variants like the HTML/XHTML families have).
  - `WebContextText extends TextTargetContext implements ru.myx.ae3.i3.web.WebContext<TextTargetContext>` — the HTTP-reply-producing adapter (see `ae3.sys.pkg.i3.web`'s CLAUDE.md for the dispatch mechanism). Registered for `txt` via `ae3-packages/ae3.sys.l2.tgt.text/settings/system/l3/targets/text.json`.
  - `TestText.java` — manual smoke-test entry point, same shape as this family's other `Test*` classes.

## Build

- Requires (Java): `ae3.sdk`, and `ae3.web` (for `WebContextText`; `.classpath` needs a matching `path="/ae3.sys.pkg.i3.web"` `classpathentry`). Every other cross-package import resolves to `ru.myx.ae3.i3.TargetInterface` (`ae3.api`) or `ru.myx.ae3.l2.*`/`ru.myx.ae3.Engine`/`ru.myx.ae3.report.Report`/`ru.myx.ae3.binary.*` (`ae3.sdk`).
- No `package.json` under `ae3-packages/` (unlike the other `l2.tgt.*` units) — the bundle folder itself is named `ae3.sys.l2.tgt.text`, the only naming signal available here, consistent with the pattern seen elsewhere: `ae3.sys.pkg.l2.tgt.<X>` directory -> `ae3.sys.l2.tgt.<X>` bundle/Provides name.

## Gotchas

- 8 compiled `.class` files are checked into git under `bin/` — not yet cleaned up.
- See `ae3.sys.pkg.l2.tgt.html`'s CLAUDE.md for why `l2.tgt.xml`'s three-entry `Provides:` shape isn't treated as a confirmed convention here.
