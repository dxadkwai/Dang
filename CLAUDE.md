# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

`acctual.html` is a single-file static landing page recreating the Acctual invoicing product site. All HTML, CSS, and inline SVGs live in this one file — no build step, no bundler, no dependencies beyond a Google Fonts import.

To preview: open `acctual.html` directly in a browser, or serve it with any static server:

```bash
npx serve .
# or
python -m http.server 8080
```

## Design tokens

All colors are defined as CSS custom properties on `:root` at the top of the `<style>` block. Always use these variables — never hardcode hex values inline:

| Variable | Value | Use |
|---|---|---|
| `--bg` | `#f7fafc` | Page background |
| `--dark` | `#1e1e1e` | Primary text, buttons |
| `--muted` | `#666` | Secondary text |
| `--blue` | `#0098f2` | Accent / links |
| `--pink` | `#f200ca` | Accent 2 |
| `--purple` | `#6c56fc` | Accent 3 |
| `--green` | `#5d9c06` | Success / paid status |
| `--red` | `#ff6363` | Error / overdue status |
| `--border` | `#e8edf2` | Borders and dividers |

Each accent color has a `29` (hex ~16% opacity) tinted variant for backgrounds: `--blue-light`, `--pink-light`, `--purple-light`, `--green-light`, `--red-light`.

## Page sections (in order)

1. **Nav** — sticky, glassmorphism blur, `.nav-logo` / `.nav-links` / `.nav-right`
2. **Hero** — centered, `.hero-badge` pill + `<h1>` + `.trusted-row` logos
3. **Quote band** — full-width white bar, `.quote-band`
4. **For whom grid** — `.whom-grid` (3-col), `.whom-card` with colored `.whom-icon`
5. **Problem section** — `.problem-section` (white bg), `.problem-cards` (3-col): `.p-slow` / `.p-stress` / `.p-complex`
6. **Same day payments** — `.payments-grid` (2-col), `.invoice-cards` with `.status-badge` variants `s-paid` / `s-proc` / `s-due`
7. **Invoice designer** — `.designer-section` (white bg), `.designer-cols` (2-col)
8. **Dark product preview** — `.dark-section`, `.invoice-preview` mock invoice
9. **More features** — `.more-features` (2-col), `.mf-block`
10. **Integration** — `.integration-section` (white bg), `.int-badges`
11. **Final CTA** — `.cta-section`
12. **FAQ** — native `<details>`/`<summary>` elements inside `.faq-section`
13. **Footer** — `.footer-top` (4-col grid) + `.footer-bottom`

## Conventions

- Sections alternate between `background: white` and `background: var(--bg)`.
- White-background sections add `border-top: 1px solid var(--border)` and `border-bottom: 1px solid var(--border)`.
- Content is constrained via `max-width: 1080px; margin: 0 auto` wrapper divs (`.section-wrap`) with `padding: 80px 40px`.
- Typography scale: section headings use `font-size: clamp(32px, 3.8vw, 42px)` with `font-weight: 800` and `letter-spacing: -1.2px`.
- The only interactive element is the FAQ accordion — it uses native `<details>` with `details summary { list-style: none }` to suppress the default marker.
- Responsive breakpoint at `max-width: 768px` collapses all multi-column grids to 1- or 2-column.
- Font: Inter loaded from Google Fonts (weights 300–900).
