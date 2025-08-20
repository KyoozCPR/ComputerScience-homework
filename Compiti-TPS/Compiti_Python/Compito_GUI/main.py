from tkinter import ttk

import customtkinter as tk


class Inventario(tk.CTk):
    def __init__(self):
        super().__init__()

        tk.set_default_color_theme("dark-blue")

        self.title("Inventario")
        self.geometry("750x500")




        self.greeting = tk.CTkLabel(self, text="Benvenuto nell'inventario")
        self.greeting.pack()
        self.greeting_sub = tk.CTkLabel(self, text="hai già un database o vuoi crearlo da 0?")
        self.greeting_sub.pack()
        self.framewrapper = tk.CTkFrame(self)
        self.framewrapper.pack(pady=50)
        self.button = tk.CTkButton(self.framewrapper, text="Ho un database")
        self.button2 = tk.CTkButton(self.framewrapper, text="Sì crealo")

        self.button.grid(column=0, row=0, sticky=tk.W)
        self.button2.grid(column=2, row=0)



    def cerca_database(self):
        pass

    def crea_database(self):
        pass




inventario = Inventario()
inventario.mainloop()