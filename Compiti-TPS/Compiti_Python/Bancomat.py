"""
Scrivere un programma che simuli le operazioni su un bancomat,
per prima cosa il programma deve chiedere all'utente
username e password che sono rispettivamente (nome studente, data di nascita con "-" di separatore).
Dopo 3 tentativi falliti dovete comunicare che il bancomat è stato bloccato.

In caso la login vada a buon fine viene mostrato il seguente menu:1)VERSA CONTANTI
2)RITIRA CONTANTI
3)STAMPARE DATA E ORA DELL'ULTIMA OPERAZIONE
4)STAMPA IL SALDO
5) ESCI

P.S. FAI IN MODO DA NON PERMETTERE UN PRELIEVO IN CASO IL SALDO DIVENTASSE NEGATIVO
"""
import datetime
USERNAME = "Diego"
PASSWORD = "31-03-2008"

tentativi = 3
saldo = 0
lastdate = datetime.datetime.now()
def getCredentials():
    global tentativi #definisco global perché devo modificare la variabile
    username = input("Inserisci lo username: ")
    password = input("Inserisci la password: ")

    if password != PASSWORD or username != USERNAME:
        tentativi -= 1
        print(f"le credenziali inserite sono errate, riprovare!\n\nTENTATIVI RIMASTI: {str(tentativi)}")
        if tentativi == 0:
            print("IL BANCOMAT E' STATO BLOCCATO")
            return
        getCredentials()



def versa(quantità: float):
    global saldo, lastdate
    if quantità <= 0:
        quantità = float(input("Quantità non valida, reinserisci l'importo!: "))
        versa(quantità)
    lastdate = datetime.datetime.now()
    saldo += quantità
    print(f"Conto aggiornato, totale attuale: {str(saldo)}")


def prelievo(quantità: float):
    global saldo, lastdate
    if quantità > saldo:
        quantità = float(input("Quantità non valida, reinserisci l'importo!: "))
        prelievo(quantità)
    lastdate = datetime.datetime.now()
    saldo -= quantità
    print(f"Conto aggiornato, totale attuale: {saldo}")

def menu(scelta: int):
    if scelta == 0:
        print("ARRIVEDERCI!")
        return
    elif scelta == 1:
        quantità = int(input("Inserisci la quantità di soldi da inserire nel conto: "))
        versa(quantità)
    elif scelta == 2:
        quantità = int(input("Inserisci la quantità di soldi da prelevare dal conto: "))
        prelievo(quantità)
    elif scelta == 3:
        print(lastdate)


if __name__ == "__main__":
    print("BENVENUTO NEL BANCOMAT, PERFAVORE INSERIRE LE CREDENZIALI")
    getCredentials()
    if tentativi != 0:
        while True:
            print(
                """
                    \n0)ESCI
                    1)VERSA CONTANTI
                    2)RITIRA CONTANTI
                    3)STAMPARE DATA E ORA DELL'ULTIMA OPERAZIONE
                    4)STAMPA IL SALDO
                 """
            )
            scelta = int(input("Scegli tra una delle opzioni: "))
            menu(scelta)
            if scelta == 0:
                break

