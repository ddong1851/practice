from tkinter import *

root = Tk()

root.title("동률의 창")
root.geometry("640x400+100+100")
root.resizable(False, False)

label = Label(root, text="안녕 동률")
label.pack()

root.mainloop()