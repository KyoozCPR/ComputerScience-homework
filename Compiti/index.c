#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define DIM 5

typedef struct{
    int x;
    int y;
    int quadrante;
}punto;

void caricaValori(punto[]);
int scelta();
void menu(int,punto[]);
void es1(punto[]);
void es2(punto[]);
void es3(punto[]);
void es4(punto[]);
void es5(punto[]);

int main()
{
    srand(time(NULL));
    
    punto database[DIM];
    
    caricaValori(database);
    int s;
    
    
    do{
        s=scelta();
        menu(s,database);
    } while(s != 0);
    
    
    
    return 0;
}


void caricaValori(punto database[]){
    for(int i=0; i<DIM; i++){
        database[i].x=(-10) + rand() % (10 - (-10) + 1);
        database[i].y=(-10) + rand() % (10 - (-10) + 1);
        if(database[i].x>0&&database[i].y>0)
            database[i].quadrante=1;
        else if(database[i].x<0&&database[i].y>0)
            database[i].quadrante=2;
        else if(database[i].x<0&&database[i].y<0)
            database[i].quadrante=3;
        else if(database[i].x>0&&database[i].y<0)
            database[i].quadrante=4;
        else 
            database[i].quadrante=0;

        printf("il punto %d ha valori: (%d,%d)\n", i, database[i].x, database[i].y);
    }
}

int scelta(){
    int scelta;
    printf("\n1. Visualizzare un punto selezionato\n2. Visualizzare tutti i punti in un certo insieme\n3. Restiruire la distanza tra due punti selezionati\n4. Restituire il punto medio tra due punti\n5. Restituire in ordine i punti piu vicino all'origine\n");
    scanf("%d",&scelta);
   
    return scelta;
}

void input(punto *p1, punto *p2, punto database[]){
    int punto1, punto2; 
    do {
        printf("inserisci punto 1: ");
        scanf("%d", &punto1);
        printf("inserisci punto 2: ");
        scanf("%d", &punto2);
    } while((punto1 < 0 || punto1 >= DIM) || (punto2 < 0 || punto2 >= DIM));
    
    (*p1) = database[punto1];
    (*p2) = database[punto2];
}



void menu(int scelta, punto database[]){
    
    switch(scelta){
        case 0: 
            printf("\nArrivederci!");
            break;
        case 1:
            es1(database);
            break;
        case 2:
            es2(database);
            break;
        case 3:
            es3(database);
            break;
        case 4:
            es4(database);
            break;
        case 5:
            es5(database);
            break;
        default: 
            printf("Scelta non valida! riprova");
            
    }
}

void stampa_punto(punto p, char* buffer) {
    
    const char* quadranti[] = {
        "0",   
        "Primo",       
        "Secondo",     
        "Terzo",       
        "Quarto"       
    };
    
    sprintf(buffer, "P=(%d,%d) - %s", p.x, p.y, quadranti[p.quadrante]);
}


void es1(punto database[]){
    int puntoS;
    
    do{
        printf("Quale punto vuoi Visualizzare?\t");
        scanf("%d",&puntoS);
    }while(puntoS>DIM || puntoS<0);
    
   
    printf("Il punto ha coordinate (%d,%d) e si trova nel %d quadrante",database[puntoS].x,database[puntoS].y,database[puntoS].quadrante);
}


void es2(punto database[]){
    int qS;
    char stringa_finale[50]; 
    do {
        printf("Di che quadrante vuoi Visualizzare i punti?\t");
        scanf("%d",&qS);
    } while(qS>4 || qS<0);


     for (int i=0; i<DIM; i++){
        if(database[i].quadrante == qS){
            stampa_punto(database[i], stringa_finale);
            printf("%s\n", stringa_finale);
        }
    }
    
    
}


void es3(punto database[]){
    punto p1, p2;
    int result;
    input(&p1, &p2, database);
    
    result = sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
    
    printf("La distanza è %d",result);
}


void es4(punto database[]){
    punto p1, p2;
    int result1, result2;
    input(&p1, &p2, database);
    
    result1=(p1.x + p2.x)/2;
    result2=(p1.y + p2.y)/2;
    printf("Il punto medio è (%d,%d)",result1,result2);
}

void es5(punto database[]){
    
    float distanze[DIM];
    punto appoggioP;

    for(int i=0;i<DIM;i++){
        distanze[i] = sqrt(pow(database[i].x, 2) + pow(database[i].y, 2));
    }
    
    int min=0;
    float appoggio;
      for(int i=0;i<DIM;i++){
        min=i;
        for(int j=i+1;j<DIM;j++){
          if(distanze[i]<distanze[min])
            min=j;
        }
        appoggio=distanze[i];
        distanze[i]=distanze[min];
        distanze[min]=appoggio;

        appoggioP = database[i];
        database[i] = database[min];
        database[min] = appoggioP;

      }
      
    for(int i = 0; i < DIM; i++) 
        printf("Punto %d: (%d,%d), Distanza: %.2f\n", i, database[i].x, database[i].y, distanze[i]);
    
}