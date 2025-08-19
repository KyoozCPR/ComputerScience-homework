from tkinter import ttk

import customtkinter as tk


class Inventario(tk.CTk):
    def __init__(self):
        super().__init__()
        tk.set_default_color_theme("dark-blue")
        self.geometry("750x500")
        self.title = tk.CTkLabel(self, text="Benvenuto nell'Inventario")
        self.title.pack(pady=50)
        self.frame = tk.CTkFrame(self)
        self.frame.pack()
        self.button = tk.CTkButton(self.frame, text="test")
        self.button2 = tk.CTkButton(self.frame, text="test2")
        self.button3 = tk.CTkButton(self.frame, text="test3")
        self.button.grid(column=0, row=0)
        self.button2.grid(column=1, row=0, padx=20, pady=20)
        self.button3.grid(column=2, row=0)
inventario = Inventario()
inventario.mainloop()