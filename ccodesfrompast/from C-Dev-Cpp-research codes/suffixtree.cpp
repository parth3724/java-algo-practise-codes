#include<iostream>
#include<stack>
using namespace std;

#define INFINITE 20000
class structnode;
class structedge;
 char datatext[] = {'0','1','0','1','0','0','\0'};

class structedge{
      public:
             int start_index;
             int end_index;
             structnode *destination;
             
              structedge()
              {
               start_index=0;
               end_index=0;
               destination=NULL;            
              }
              structedge( int init_first_char_index,int init_last_char_index,structnode *end_node )
              {
                 start_index= init_first_char_index;
                 end_index=init_last_char_index;
                 destination=end_node;
              }
              
              structedge operator=(structedge other)
              {
                   // return structedge(other.start_index,other.end_index,other.destination);                      
                  start_index= other.start_index;
                  end_index=other.end_index;
                  destination=other.destination;
              }
              
              void show()
              {
               if(this==NULL)
                   {
                                 cout<<"\n Null edge\n";
                                 return;
                                 }
                  cout<<"\n printing info for edge\n";
                  cout<<this<<" "<<start_index<<" "<<end_index<<" "<<destination<<"\n";      
              }
      };

class structnode {
      public:
          structnode *suffixnode;
          structedge *edge[2];
          structnode()
          {
            suffixnode = NULL;
            edge[1]=NULL;
            edge[0]=NULL;   
          }
          void show()
          {
                             if(this==NULL)
                   {
                                 cout<<"\n Null node\n";
                                 return;
                                 }
                       cout<<"\n printing info for node\n";
                       cout<<this<<" "<<edge[0]<<" "<<edge[1]<<" "<<suffixnode<<"\n";
          }
          structnode operator=(structnode other)
          {
                     suffixnode=other.suffixnode;
                     edge[0]=other.edge[0];
                     edge[1]=other.edge[1];
                     }
          
};
 structnode root ;
 
void canonize(structnode **s, int *startindex, int endindex)
{
//1. if p < k then return (s, k)     
 if(endindex < *startindex)
 return;
 
 

 structedge *temedge;
 int k;
 k=*startindex;


if(*s == NULL)
{
 cout<<"s is NULL      \n";
 system("pause");
}
////3. find the tk–transition g'(s, (k', p')) = s' from s; 
 if((*s)->edge[0]!= NULL && datatext[((*s)->edge[0])->start_index] == datatext[k])
{

  temedge=((*s)->edge[0]);/////////////////////////////////////////////////////////////////
}
 else if((*s)->edge[1]!= NULL)        
{

  temedge=((*s)->edge[1]);
}
 else
 {
     cout<<"\n Line 101 No required transition from given node\n error in graph \n";
     return;
     }
///////4. while p' - k' <= p - k do


while(((*temedge).end_index  - (*temedge).start_index) <= (endindex - (*startindex)))
{
      k=k+((*temedge).end_index  - (*temedge).start_index)+1;
      *startindex=k;

   *s=(*temedge).destination;
    //////7. if k <= p then find the tk–transition g'(s, (k', p')) = s' from s;
   if(k<= endindex)
   {
          
     if((*s)->edge[0]!= NULL && datatext[((*s)->edge[0])->start_index] == datatext[k])
     {

       temedge=((*s)->edge[0]);
     }
     else if((*s)->edge[1]!=NULL)         
     {

      temedge=((*s)->edge[1]);
     }     
      else
     {
     cout<<"\n Line 129 No required transition from given node\n error in graph \n";
     return;
     }  
   }
  
}
}


bool testandsplit(structnode **s,int startindex, int endindex, char c)
{
 if(startindex<=endindex)
 {
   structedge *currentedge;
   
   if((*s)->edge[0]!= NULL && datatext[((*s)->edge[0])->start_index] == datatext[startindex])
     currentedge=(*s)->edge[0];
   else if((*s)->edge[1]!= NULL && datatext[((*s)->edge[1])->start_index] == datatext[startindex])
     currentedge=(*s)->edge[1];
 
   if(currentedge == NULL)
   {
   cout<<"NULL EDGE";
   system("pause");
   exit(0);               
   }       
   if(c== datatext[(currentedge->start_index) + endindex - startindex +1])
    return true;
   else//split
    { 
      structnode *temnode;
      structedge *newedge=new structedge();
      structnode *newnode=new structnode();

      newedge->destination=currentedge->destination;
      newedge->end_index=currentedge->end_index;
      currentedge->end_index=(currentedge->start_index) + endindex - startindex;
      newedge->start_index=(currentedge->end_index)+1;
      
      newnode->edge[datatext[ newedge->start_index] - '0']= newedge;
      currentedge->destination=newnode;
      *s = newnode;         
      return false;
    }   
                                                                       
 }     
 else
 {
     if(((*s)->edge[0]!=NULL && c==datatext[((*s)->edge[0])->start_index]) || ((*s)->edge[1]!=NULL && c== datatext[((*s)->edge[1])->start_index]))
     return true;
     else
     return false;
         
 }
}

void update(structnode **s,int *k,int i)
{
 structnode *oldroot;
 oldroot=&root;
 
 structnode *scrappointer = *s;
 structnode **temnode;
 temnode = &scrappointer;
 *temnode=*s;
 cout<<"\ntemnode,*temnode,**temnode\n"<<temnode<<" "<<*temnode<<"\n";

 (**temnode).show();
  structnode *newnode;
  structedge *newedge;
 while(!testandsplit(s,*k,i-1,datatext[i]))
 {
  newnode= new structnode();
  newedge= new structedge();
  newedge->start_index = i;
  newedge->end_index = INFINITE;
//  newedge->destination=newnode;

 
  (*s)->edge[datatext[i]-'0']=newedge;                       

  if(oldroot!=&root)
  {
   oldroot->suffixnode=*s;                  
  }
  oldroot=*s;
//  s=temnode;
  *s=*temnode;
  cout<<"\ns,*s,**s\n"<<s<<" "<<*s<<"\n";
  (**s).show();
  system("pause");
 if((*s)->suffixnode == NULL)
 {
  cout<<"suffix of this node is null\n";
  system("pause");                    
 }
  *s=(*s)->suffixnode;
  canonize(s,k,i-1);
  *temnode=*s;
 }     
 *s=*temnode;
 if(oldroot!=&root)
 {
  oldroot->suffixnode=*s;
 }
}

void showtree(structnode *start)
{
 stack <structnode*> stackk;    
 structnode *current; 
 stackk.push(start);   
 while(!stackk.empty())
 {
  current=stackk.top();
  current->show();
     stackk.pop();
  for(int i=0;i<2;i++)
  {
  if(current->edge[i] != NULL)
  {
   (current->edge[i])->show();
   if((current->edge[i])->destination != NULL)
   stackk.push((current->edge[i])->destination);
   }
}
 }
}
int main()
{
   
    structnode ultaT;
    
    structedge edgeone;
    structedge edgetwo ;
///    2. for j   1, . . . ,m do create transition g0(ultaT, (-j,-j)) = root; 
// because of above step,  we have to add entire alphabet at the beginging of 
// datatext array. 
edgeone.start_index=0;
edgeone.end_index=0;
edgeone.destination=&root;
edgetwo.start_index=1;
edgetwo.end_index=1;
edgetwo.destination=&root;
ultaT.edge[0]=&edgeone;
ultaT.edge[1]=&edgetwo;
root.suffixnode=&ultaT;
/*  structedge edgethree ;
    structnode nodeone ;
    structnode nodetwo ;
    structnode nodethree ;
    edgeone.destination=&nodeone;
    edgetwo.destination=&nodetwo;
//    edgethree.destination=&nodethree;
//    nodeone.edge[0]=&edgethree;
    edgeone.start_index=0;
    edgeone.end_index=1;
    edgetwo.start_index=1;
    edgetwo.end_index=1;
    root.edge[0]=&edgeone;
    root.edge[1]=&edgetwo;
//    edgethree.start_index=1;
 //   edgethree.end_index=1;
    root.show();
    edgeone.show();
    edgetwo.show();
/*debug    cout<<"\n debug: edgeone show\n";    */
 //   edgeone.show();
/*debug structedge *temedge; */
/*debug temedge = (root.edge[0]);*/
/*debug cout<<"\n debug : copy of above edge show \n";*/
/*debug (*temedge).show();*/
 //   nodethree.show();
 
    int startindex = 2;
//    canonize(sample2,&startindex,1);
//    if(!testandsplit(sample2,0,0,'0'))
//     {edgeone.show(); ((edgeone.destination)->edge[1])->show();}
 //    else                                     
  //  (**sample2).show();
 //   cout<<"\n"<<startindex<<"\n";
 
   structnode *sample=NULL;
    sample=  &root;
    structnode **sample2=NULL;
    sample2 = &sample;   
   for(int i=2;datatext[i]!='\0';i++)
   {
    update(sample2,&startindex,i);
    if(*sample2 == NULL)
    {
     cout<<"sample2 is null \n";
     system("pause");
     break;            
    }
    canonize(sample2,&startindex,i);                              
   }
   
   root.show();
   cout<<"***********************\n";
   showtree(&root);
    
    system("pause");
    return 0;
}
