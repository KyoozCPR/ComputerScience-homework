from tkinter import ttk

import customtkinter as tk



class Inventario(tk.CTk):
    def __init__(self):
        super().__init__()
        self.error = None
        self.database_path = "farmaci.txt"
        tk.set_default_color_theme("dark-blue")

        self.title("Inventario")
        self.geometry("750x500")



        self.titleFrame = tk.CTkFrame(self, fg_color="transparent")
        self.greeting = tk.CTkLabel(self.titleFrame, text="Benvenuto nell'inventario", font=("Arial", 30))
        self.greeting.pack()
        self.greeting_sub = tk.CTkLabel(self.titleFrame, text="hai già un database o vuoi crearlo da 0?",  font=("Arial", 15))
        self.greeting_sub.pack()
        self.titleFrame.pack(pady=20)

        self.framewrapper = tk.CTkFrame(self)
        self.framewrapper.pack(pady=100)
        self.button = tk.CTkButton(self.framewrapper, text="Ho già un database", fg_color="black", command=self.cerca_database)
        self.button2 = tk.CTkButton(self.framewrapper, text="Sì crealo", command=self.crea_database)

        self.button.grid(column=0, row=0, sticky=tk.W)
        self.button2.grid(column=2, row=0)


        self.codiceBarre = None
        self.NomeFarmaco = None
        self.scadenza = None
        self.prezzo = None
        self.quantità = None



    def cerca_database(self):
        database = tk.filedialog.askopenfilename()
        if database[-3:] == "txt":
            self.database_path = database
            self.elimina_pagina()
        else:

            self.error = tk.CTkLabel(self, text="Il database può essere solamente un file di tipo .txt!", text_color="red")
            self.error.pack()


    def crea_database(self):
        with open("farmaci.txt", "w") as database:
            self.elimina_pagina()

    def elimina_pagina(self):
        self.greeting.destroy()
        self.greeting_sub.destroy()
        self.framewrapper.destroy()
        if self.error is not None:
            self.error.destroy()




inventario = Inventario()
inventario.mainloop()