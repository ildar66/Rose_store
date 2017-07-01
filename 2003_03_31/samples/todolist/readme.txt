--------------------------------------------------------------------------
	    
                 Rational Rose 2000 Visual Basic 6
                         ToDoList Sample
	                   ReadMe.txt

--------------------------------------------------------------------------

This sample is based on:
Doing Objects in Microsoft Visual Basic 5.0, Deborah Kurata, (c) 1997 Ziff-Davis
Press:
	Saving Objects to a File

	Project Name:	Task11_2.vbp
	File Folder:	Ex11_2

        This sample project demonstrates a generic file processing class. This
        class stores any object data to a file. In this example, all of the
        tasks in the collection are stored in a simple binary file. The
        resulting application allows you to define a set of tasks in a to do
        list and save those tasks. When the application is run again, the
        tasks will be read from the file and displayed.  For a challenge, try
        the following:
         - Implementing the code to add the category to the file.
         - Changing the file type to write the data to a sequential file that
           can be opened with a text editor.

Quick Start Notes:

1) Open the ToDoList.mdl Rose model under the rose_install_dir/samples/ToDoList folder.

2) Generate Visual Basic code for the main classes in the model:
   - In the Logical View/Three-Tier Service Model diagram, select all the 
     classes (control-A).
   - Select Tools->Visual Basic->Update Code. You can pick the defaults
     (via Next and Finish buttons) in the Code Update Tool, or you may
     inspect or change each class' mapping to Visual Basic code by
     right-clicking on a class and choosing Open from the shortcut
     menu, which brings up the Model Assistant for the class.

3) In Visual Basic, inspect the task11_2.vbp project. The implementation code was
   previously supplied in VB. To run this example, first set your VB options to
   Break_On_Unhandled_Errors in the Tools->Options->General dialog, then run the
   application (Run->Start_With_Full_Compile). Modify the project as desired.

4) Reverse Engineer the Visual Basic code back into the Rose model:
   - In Rose, select Tools->Visual Basic->Update Model from Code. You can select
     the defaults (via Next and Finish buttons).

5) In Rose, inspect the updated model.


----------------------------------------------------------------------
Copyright (c) 2000 Rational Software Corporation. All rights reserved.
