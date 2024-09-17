#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define DIM 5

typedef struct{
    float x;
    float y;
    int quadrante;
}punto;

void caricaValori(punto*);
int scelta();
void menu(int,punto*);
void es1(punto*);
void es2(punto*);
void es3(punto*);
void es4(punto*);
void es5(punto*);

int main()
{
    srand(time(NULL));
    
    punto database[DIM];
    
    caricaValori(database);
    
    
    int scelta=scelta();
    
    menu(scelta,database);
    
    
    return 0;
}


void caricaValori(punto database[]){
    for(int i=0; i<DIM; i++){
        database[i].x=rand()%11;
        database[i].y=rand()%11;
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
        
    }
}

int scelta(){
    int scelta;
    do {
        printf("1. Visualizzare un punto selezionato\n2. Visualizzare tutti i punti in un certo insieme\n3. Restiruire la distanza tra due punti selezionati\n4. Restituire il punto medio tra due punti\n5. Restituire in ordine i punti piu vicino all'origine\n");
        scanf("%d",&scelta);
    } while(scelta<0||scelta>5);
    return scelta;
}

void input(punto database[]){
    int punto1, punto2;
    punto p1, p2;
    do {
        printf("inserisci punto 1: ");
        scanf("%d", &punto1);
        printf("inserisci punto 2: ");
        scanf("%d", &punto2);
    } while((punto1 < 0 || punto1 > DIM) || (punto2 < 0 || punto2 > DIM));
    (*p1) = database[punto1];
    (*p2) = database[punto2];
}

void menu(int scelta, punto database[]){
    
    switch(scelta){
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
    }
}

void es1(punto database[]){
    int puntoS;
    do{
        printf("Quale punto vuoi Visualizzare?\t");
        scanf("%d",&puntoS);
    }while(puntoS>DIM || puntoS<0);
    
    printf("Il punto ha coordinate (%f,%f) e si trova nel %d° quadrante",database[puntoS].x,database[puntoS].y,database[puntoS].quadrante);
}


void es2(punto database[]){
    int qS;
    do{
        printf("Di che quadrante vuoi Visualizzare i punti?\t");
        scanf("%d",&qS)
    }while(qS>4 || qS<0);
    
    for(int i=0; i<DIM; i++){
        if(database[i].quadrante==qS)
            printf("Il punto al posto %d ha coordinate(%f,%f) e si trova nel %d° quadrante\n",i,database[i].x,database[i].y,qS);
    }
}


void es3(punto database[]){
    int p1;
    int p2;
    int r1;
    int r2;
    
    do{
        printf("inserisci il primo punto\t");
        scanf("%d",&p1);
        
    }while(p1<0||p1>DIM); 
    
     do{
        printf("inserisci il secondo punto\t");
        scanf("%d",&p2);
        
    }while(p2<0||p2>DIM); 
    
    if (database[p1].x>database[p2].x){
        r1=database[p1].x-database[p2].x;
        r1=pow(r1,2);
    }
    else if(database[p1].x<database[p2].x){
        r1=database[p2].x-database[p1].x;
        r1=pow(r1,2);
    }
    else {
        r1=database[p1].x-database[p2].x;
        r1=pow(r1,2);
    }
    
    if (database[p1].y>database[p2].y){
        r2=database[p1].y-database[p2].y;
        r2=pow(r2,2);
    }
    else if(database[p1].y<database[p2].y){
        r2=database[p2].y-database[p1].y;
        r2=pow(r2,2);
    }
    else {
        r2=database[p1].y-database[p2].y;
        r2=pow(r2,2);
    
    r1=r1+r2;
    sqrt(r1);
    
    printf("La distanza è %d",r1);
}


void es4(punto database[]){
    int p1;
    int p2;
    int r1;
    int r2;
    
    do{
        printf("inserisci il primo punto\t");
        scanf("%d",&p1);
        
    }while(p1<0||p1>DIM); 
    
     do{
        printf("inserisci il secondo punto\t");
        scanf("%d",&p2);
        
    }while(p2<0||p2>DIM);
    
    r1=database[p1].x+database[p2].x;
    r2=database[p1].y+database[p2].y;
    
    printf("Il punto medio è (%d,%d)",r1/2,r2/2);
}

void es5(punto database[]){
    
    float distanze[DIM];
    
    for(int i=0;i<DIM;i++){
        int r1;
        int r2;
        r1=database[i].x-0;
        r1=pow(r1,2);
        r2=database[i].x-0
        r2=pow(r2,2);
        r1=r1+r2;
        sqrt(r1);
        distanze[i]=r1;
    }
    
    int min=0;
    punto appoggio;
      for(int i=0;i<DIM;i++){
        min=i;
        for(int j=i+1;j<DIM;j++){
          if(distanze[i]<distanze[min])
            min=j;
        }
        appoggio=distanze[i];
        distanze[i]=distanze[min];
        distanze[min]=appoggio;
      }
      
      for(int i=0; i<DIM;i++){
          printf("il punto piu vicino all origine è ")
      }
        
}

