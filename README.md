# Workshops

## REST

### Rest principles and the art of code generation

# License

This project is licensed
under [CC BY-NC-ND 4.0](https://creativecommons.org/licenses/by-nc-nd/4.0/).
> _You can download and share the materials, but you cannot change them in any way or use them
> commercially._

# Pandoc (for presentation generation only)

Install pandoc for generating slides

- `brew install pandoc`
- `sudo apt-get install pandoc`

And generate the presentation using `pandoc -t revealjs --variable theme="simple" -s -o presentation.html slides.md`
pandoc -t revealjs -s -o presentation.html slides.md --slide-level=3 --variable theme=white --include-in-header=header.html
