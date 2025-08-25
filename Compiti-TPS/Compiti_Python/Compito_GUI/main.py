from tkinter import ttk
import customtkinter as tk
from customtkinter import CTkButton
import re

class Inventario(tk.CTk):
    def __init__(self):
        super().__init__()
        self.resultsN = 0
        self.modificaButton = None
        self.resultsPageLabel = None
        self.resultsView = None
        self.resultsFrame = None
        self.successo = None
        self.error = None
        self.entrys = []
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

        self.formFrame = None
        self.casaFarmaceutica = None
        self.codiceBarre = None
        self.NomeFarmaco = None
        self.scadenza = None
        self.prezzo = None
        self.quantità = None

        self.buttonFormFrame = None
        self.cercaButton = None
        self.modificaCampiButton = None
        self.inserireNuovoProdottoButton = None



    def show_message(self, text, color):
        if self.successo:
            self.successo.destroy()
            self.successo = None
        if self.error:
            self.error.destroy()
            self.error = None

        label = tk.CTkLabel(self, text=text, text_color=color)
        label.pack(pady=20)

        if color == "green":
            self.successo = label
        else:
            self.error = label

    def cerca_database(self):
        database = tk.filedialog.askopenfilename()
        if database[-3:] == "txt":
            self.database_path = database
            self.elimina_pagina()
        else:
            if not database:
                return
            self.show_message("Il database può essere solamente un file di tipo .txt!", "red")

    def crea_database(self):
        with open("farmaci.txt", "w") as database:
            self.elimina_pagina()

    def elimina_pagina(self):
        self.greeting.destroy()
        self.greeting_sub.destroy()
        self.framewrapper.destroy()
        if self.error is not None:
            self.error.destroy()
            self.error = None
        self.create_form()

    def validateNumeri(self):
        if not self.quantità.get().isdigit() or not self.prezzo.get().isdigit():
            self.show_message("Quantità deve essere un numero intero!", "red")
            return False


        return True

    def create_form(self):
        self.formFrame = tk.CTkFrame(self)
        self.casaFarmaceutica = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Casa Farmaco")
        self.codiceBarre = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Codice Barre")
        self.NomeFarmaco = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Nome Farmaco")
        self.scadenza = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Scadenza")
        self.prezzo = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Prezzo")
        self.quantità = tk.CTkEntry(self.formFrame, font=("Arial", 15), placeholder_text="Quantità")




        self.formFrame.pack()
        self.casaFarmaceutica.grid(column=0, row=0)
        self.codiceBarre.grid(column=1, row=0, padx=30)
        self.NomeFarmaco.grid(column=2, row=0)
        self.scadenza.grid(column=0, row=1)
        self.prezzo.grid(column=1, row=1, padx=30, pady=100)
        self.quantità.grid(column=2, row=1)

        self.buttonFormFrame = tk.CTkFrame(self, fg_color="transparent")
        self.cercaButton = tk.CTkButton(self.buttonFormFrame, text="cerca", command=self.cercaProdotto, width=240)
        self.inserireNuovoProdottoButton = tk.CTkButton(self.buttonFormFrame, text="inserire nuovo prodotto", command=self.inserireNuovoProdotto, width=240)

        self.buttonFormFrame.pack()
        self.cercaButton.grid(column=0, row=0)
        self.inserireNuovoProdottoButton.grid(column=2, row=0)

    def insertEntrys(self):
        self.entrys.append(self.casaFarmaceutica.get())
        self.entrys.append(self.codiceBarre.get())
        self.entrys.append(self.NomeFarmaco.get())
        self.entrys.append(self.scadenza.get())
        self.entrys.append(self.prezzo.get())
        self.entrys.append(self.quantità.get())

        self.entrys = [e for e in self.entrys if e]

    def checkFormMissing(self):
        if not self.casaFarmaceutica.get() or not self.codiceBarre.get() or not self.NomeFarmaco.get() or not self.scadenza.get() or not self.prezzo.get() or not self.quantità.get():
            return True
        return False

    def inserireNuovoProdotto(self):

        if self.checkFormMissing():
            self.show_message("tutti i campi devono essere compilati!", "red")
            return

        with open(self.database_path, "a") as database:
            if not self.checkEntry() or not self.validateNumeri():
                return
            self.insertEntrys()
            database.write(f"{str(self.casaFarmaceutica.get())};{str(self.codiceBarre.get())};{str(self.NomeFarmaco.get())};{str(self.scadenza.get())};{str(self.quantità.get())};{str(self.prezzo.get())}\n")
            self.show_message("Operazione effettuata con successo!", "green")

            self.casaFarmaceutica.delete(0, tk.END)
            self.codiceBarre.delete(0, tk.END)
            self.NomeFarmaco.delete(0, tk.END)
            self.scadenza.delete(0, tk.END)
            self.prezzo.delete(0, tk.END)
            self.quantità.delete(0, tk.END)

    def modificaProdotto(self, line: int):
        self.resultsPageLabel.forget()
        self.create_form()
        self.buttonFormFrame.pack_forget()

        with open(self.database_path, "w") as database:
            lines = database.readlines()
            lines[line] =



    def cercaProdotto(self):
        self.entrys = []
        self.insertEntrys()

        if len(self.entrys) == 0:
            self.show_message("tutti i campi devono essere compilati!", "red")
            return


        with open(self.database_path,  "r") as database:

            if self.quantità.get() or self.prezzo.get():
                self.validateNumeri()
            if self.scadenza.get():
                self.checkEntry()


            self.nascondiForm()
            self.createSearchResultsPage()
            linee = database.readlines()
            for i in range(0, len(linee)):
                entrysDatabase = linee[i].split(";")
                for forEntry in self.entrys:
                    print(forEntry)
                    if forEntry in entrysDatabase:
                            self.resultsN += 1
                            print(linee[i])
                            searchResult = tk.CTkLabel(self.resultsView, text=linee[i], anchor="w", width=200)
                            self.modificaButton = tk.CTkButton(self.resultsView, text="modifica", command=self.modificaProdotto(i),
                                                               width=50, fg_color="grey")
                            searchResult.grid(column=0, row=i)
                            self.modificaButton.grid(column=1, row=i, padx=15)

                            break

            print(self.resultsN)
            if self.resultsN == 0:
                searchResult = tk.CTkLabel(self.resultsView, text="nessun risultato trovato!", text_color="red", anchor="w", width=200)

    def nascondiForm(self):
        self.formFrame.pack_forget()
        self.casaFarmaceutica.grid_forget()
        self.codiceBarre.grid_forget()
        self.NomeFarmaco.grid_forget()
        self.scadenza.grid_forget()
        self.prezzo.grid_forget()
        self.quantità.grid_forget()
        self.buttonFormFrame.pack_forget()
        if self.successo:
            self.successo.pack_forget()
        if self.error:
            self.error.pack_forget()

    def createSearchResultsPage(self):
        self.resultsPageLabel = tk.CTkLabel(self, text=f"Ecco ha te i risultati della tua ricerca (prodotti trovati: {str(self.resultsN)}): ", font=("Arial", 20))
        self.resultsView = tk.CTkScrollableFrame(self, width=300, height=200)

        self.resultsPageLabel.place(x=135, y=10)
        self.resultsView.pack()


    def checkEntry(self):
        pattern = re.compile(
            r"^(0[1-9]|[12][0-9]|3[01])\\(0[1-9]|1[0-2])\\(19|20)\d{2}$"
        )
        if pattern.match(self.scadenza.get()) is None:
            self.show_message("la scadenza deve avere questo formato: GG\\MM\\YYYY", "red")
            return False
        return True

inventario = Inventario()
inventario.mainloop()
