print("""Scegli tra queste opzioni:
1) Inserisci dei numeri (in questo caso chiedere all'utente quanti ne vuole inserire)
2) Stampare i numeri inseriti  in fila (Es-  1 -- 2 -- 4 -- 55 -- 78 ...)
3) Stampare MIN - MAX e MEDIA dei numeri
4) Esci
""")


def inserisci_numeri():
    numeri = []
    numeriI = int(input("Quanti numeri vuoi inserire: "))
    if numeriI <= 0:
        print("numeri non valido! riprova")
        inserisci_numeri()

    while numeriI > 0:
        numeroDaInserire = int(input("Numero da inserire: "))
        numeri.append(numeroDaInserire)
        numeriI -= 1

    return numeri

def stampaArray(numeri):
    for i in numeri:
        print(f"{str(i)}--", end="")


def minMax(numeri):
    min = numeri[0]
    max = numeri[0]
    somma = 0
    media = 0
    for i in numeri:
        somma += i
        if i < min:
            min = i
        elif i > max:
            max = i
    media = somma/len(numeri)
    print(f"il valore massimo è: {str(max)}\nil valore minimo è: {str(min)}\nla media è {str(media)}")



numeriInseriti = []
def menu(scelta):


    if scelta == 1:
        numeriInseriti.extend(inserisci_numeri())
    elif scelta == 2:
        stampaArray(numeriInseriti)
    elif scelta == 3:
        print(numeriInseriti)
        minMax(numeriInseriti)
    elif scelta == 4:
        print("Arrivederci!")
        return
    else:
        print("valore non valido! riprova")
        menu(scelta)

if __name__ == "__main__":
    scelta = 0
    while scelta != 4:
        scelta = int(input("Scegli tra 1-4: "))
        menu(scelta)
