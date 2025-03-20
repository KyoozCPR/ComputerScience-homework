


def aggiungiContatto():
    nome = input("Inserisci il nome del contatto: ")
    numero = int(input("Inserisci il numero del contatto: "))


    with open("contatti.txt", "a") as contatti:
        contatti.write(f"{nome}:{numero}\n")
        print(f"{nome}:{numero} Aggiunto al file!")
    return


def modificaNumero(nomeCercare: str):
    with open("contatti.txt", "r") as contatti:
        contattiTot = contatti.readlines()
        for contatto in contattiTot:
            contattoS = contatto.split(":")

            if nomeCercare == contattoS[0]:
                numero = int(input("Inserisci il nuovo numero del contatto: "))
                contattoS[1] = str(numero)
                contattoControllo = contatto #il valore di contatto sennò verrebbe perso alla sovrascrizione
                with open("contatti.txt", "w") as contatti2:
                    for i in contattiTot:
                        print(i)
                        if i != contattoControllo:
                            contatti2.write(i)
                        else:
                            contatti2.write(":".join(contattoS) + "\n")
                print("Aggiunto Contatto!\n")
                return
    print("Contatto non trovato!")



def cancellareContatto(nomeCercare: str):
    with open("contatti.txt", "r") as contatti:
        contattiTot = contatti.readlines()
        for i in contattiTot:
            contattoS = i.split(":")
            if nomeCercare == contattoS[0]:
                with open("contatti.txt", "w") as contatti2:
                    for j in contattiTot:
                        print(j)
                        if j.split(":")[0] != nomeCercare:
                            contatti2.write(j)
                    print("Contatto cancellato!\n")
                return
    print("Contatto non trovato!")


def stampaNumero(nomeCercare: str):
    with open("contatti.txt", "r") as contatti:
        contattiTot = contatti.readlines()
        for contatto in contattiTot:
            contattoS = contatto.split(":")
            if nomeCercare == contattoS[0]:
                print(f"\nNumero di telefono di {nomeCercare} è {contattoS[1]}")
    return


def stampaOrdinato():
    with open("contatti.txt", "r") as contatti:
        contattiTot = contatti.readlines()
        contattiTot.sort()
        for contatto in contattiTot:
            print(contatto)
    return


def menu(scelta: int):
    if scelta == 0:

        return
    elif scelta == 1:
        aggiungiContatto()
        return
    elif scelta == 2:
        nomeCercare = input("Inserisci il nome del cercare: ")
        modificaNumero(nomeCercare)
        return
    elif scelta == 3:

        nomeCercare = input("Inserisci il nome del cercare: ")
        cancellareContatto(nomeCercare)
    elif (scelta == 4):
        nomeCercare = input("Inserisci il nome del cercare: ")
        stampaNumero(nomeCercare)
    elif (scelta == 5):
        stampaOrdinato()










if __name__  == "__main__":
    scelta = None

    while scelta != 0:
        print("""
1)Aggiungere un numero sul file (Il file conterrà nome:numeroTelefonico --> Colombo Ivan:3456677546)
2)Modificare un numero cercandolo per nome;
3)Cancellare un contatto;
4)Stampare il numero di telefono cercandolo per nome;
5)Stampare tutta la rubrica (in modo ordinato)
        """)

        scelta = int(input("Inserisci un numero: "))
        menu(scelta)

    if scelta==0:
        print("Arrivederci!")
        exit()

