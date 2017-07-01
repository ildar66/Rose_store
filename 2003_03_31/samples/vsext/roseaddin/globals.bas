Attribute VB_Name = "Globals"
'Rose context item types
Public Enum rose_mnu_itemtype
    rose_mnu_it_Default = 0
    rose_mnu_it_Diagram = 1
    rose_mnu_it_Package = 2
    rose_mnu_it_UseCase = 3
    rose_mnu_it_Class = 4
    rose_mnu_it_Attribute = 5
    rose_mnu_it_Operation = 6
    rose_mnu_it_Component = 7
    rose_mnu_it_Role = 8
    rose_mnu_it_Properties = 9
End Enum

'Rose context menu states
Public Enum rose_mnu_menustate
    rose_mnu_ms_Disabled = 0
    rose_mnu_ms_Enabled = 1
    rose_mnu_ms_DisabledAndChecked = 2
    rose_mnu_ms_DisabledAndUnchecked = 3
    rose_mnu_ms_EnabledAndChecked = 4
    rose_mnu_ms_EnabledAndUnchecked = 5
End Enum

'Rose context menu definition keywords
Public Const rose_mnu_Separator = "Separator"
Public Const rose_mnu_Submenu = "Submenu "
Public Const rose_mnu_EndSubmenu = "EndSubmenu"

'VSExtRose menu definitions
Public Const vse_mnu_id_UpdateCode = "vse_mnu_UpdateCode"
Public Const vse_mnu_caption_UpdateCode = "Quick Update"


