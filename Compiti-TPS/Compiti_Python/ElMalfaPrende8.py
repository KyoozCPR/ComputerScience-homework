


contatti = ["Diego:10"] 

def menu():
    print("""
    1) Aggiungi contatto
    2) Cerca contatto
    3) Visualizza tutti
    0) Salva ed esci""")
    scelta = int(input("inserisci un'opzione: "))
    return scelta
    

def aggiungiContatto():
    nominativo = input("Inserisci il tuo nome e cognome: ")
    numeroTelefono = input("Inserisci il numero di telefono")
    for i in contatti:
        nome = i.split(":")
        if nome[0] == nominativo:
            print("Utente già presente")
            return 
        else:
            contatti.append(nominativo + ":" + numeroTelefono)
            print("Contatto aggiunto alla lista!")
            return 
            
def cercaContatto():
    nominativo = input("Inserisci il nome e cognome: ")
    for i in contatti:
        contatto = i.split(":")
        if contatto[0] == nominativo:
            print(contatto[1])
            return 
      
            
    print("Utente non trovato!")        


def visualizzaContatti():
    copiaContatti = contatti
    copiaContatti.sort()
    for i in copiaContatti:
        print(i + "\n")

def scelta2(scelta):
    if scelta  == 0:
        print("ciao coglione")
    elif scelta == 1:
        aggiungiContatto()
    elif scelta == 2: 
        cercaContatto()    
    elif scelta == 3:
        visualizzaContatti()




def aggiornaFile(contaElementi, contaElementiDopoOp):
    file = open("contatti.txt", "a")
    for i in range(contaElementi, contaElementiDopoOp):
        file.write(contatti[i]+ "\n")
    file.close()


scelta = 1 #valore iniziale per entrare nel loop
with (open("contatti.txt", "r") as file):
    linee = file.readlines()
    for i in linee:
        contatti.append(i)


while (scelta != 0):
    scelta = menu()
    contaElementi = len(contatti)
    scelta2(scelta)
    contaElementiDopoOp = len(contatti)
    aggiornaFile(contaElementi, contaElementiDopoOp)




