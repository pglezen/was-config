Soft links to DocBook and FOP
=============================

These build files rely on references to DocBook stylesheets and,
in the case of PDF generation, Formatting Objects Program (FOP).
References to these artifacts are embedded in the Ant scripts
within this directory and within the DocBook customization layer
of each output type.  (Not every type requires a customization
layer.  But the PDF type almost always does.)

To version control this in a location independent way, a
softlinks directory is used to store references to the DocBook
and FOP installations.  An entry in .gitignore ensures this
directory is not added to the Git Repositories.

For each new DocBook Eclipse workspace, the owner must create
the softlinks folder and populate it with the following soft
link directory entries:

*   docbook
*   fop

In Linux and Mac systems, this can be done with the ln command.

    ln -s /path/to/DocBook docbook
    ln -s /path/to/FOP fop

run from the command line in the softlinks directory.  Windows
users should copy the DocBook and FOP directories into the 
softlinks directory since Windows does not support soft links.
