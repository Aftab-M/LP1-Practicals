import java.util.*;

public class Fits{
    
    public static void bestFit(int bl[], int m, int pr[], int n){
        
        int all[] = new int[n];
        
        for(int i=0; i<n; i++){ all[i] = -1; }
        
        
        for(int i=0; i<n; i++){
            int bestIndex = -1;
            
            for(int j=0; j<m; j++){
                
                if(bl[j] >= pr[i]){
                    if(bestIndex == -1){ bestIndex = j; }
                    else if(bl[bestIndex] > bl[j]){ bestIndex = j; }
                }   // if
                
            }   // for - j
            
            if(bestIndex != -1){ all[i] = bestIndex;  bl[i] -= pr[i]; }
            
            
            
        }   // for - i
        
        System.out.println("Process No. \t Process Size \t Block Number");
        for(int i=0; i<n; i++){
            
            System.out.println((i+1)+"\t\t"+pr[i]+"\t\t"+all[i]);
            
        }   // for - i
        
    }   // bestFit()
    
    
    
    public static void firstFit(int bl[], int m, int pr[], int n){
        
        int all[];
        all = new int[n];
        
        for(int i=0; i<n; i++){ all[i] = -1; }
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<m; j++){
                
                if(bl[j] >= pr[i]){
                    
                    all[i] = j;
                    bl[j] -= pr[i];
                    break;
                    
                }   // if
                
            }   // for - j
            
        }   // for - i
        
        System.out.println("Process No. \t Process Size \t Block Number");
        for(int i=0; i<n; i++){
            
            System.out.println((i+1)+"\t\t"+pr[i]+"\t\t"+( (all[i]==-1) ?"Not Allocated": all[i]));
            
        }   // for - i
        
        
        
    }   // firstFit()
    
    
    
    public static void nextFit(int bl[], int m, int pr[], int n){
        
        int all[] = new int[n];
        int t = m-1, j = 0;
        for(int i=0; i<n; i++){ all[i] = -1; }
        
        for(int i=0; i<n; i++){
            
            while(j<m){
                
                if(bl[j]>=pr[i]){
                    all[i] = j;
                    bl[j] -= pr[i];
                    t = (j-1)%m;
                    break;
                }   // if
                
                if(t==j){ t = (j-1)%m; break; }
                
                j = (j+1)%m;
                
            }   // while
            
        }   // for - i
        
        
        System.out.println("Process No. \t Process Size \t Block Number");
        for(int i=0; i<n; i++){
            
            System.out.println((i+1)+"\t\t"+pr[i]+"\t\t"+( (all[i]==-1) ?"Not Allocated": all[i]));
            
        }   // for - i
        
    }   // nextFit()
    
    
    
    public static void worstFit(int bl[], int m, int pr[], int n){
        
        int all[] = new int[n];
        
        for(int i=0; i<n; i++){ all[i] = -1; }
        
        
        for(int i=0; i<n; i++){
            
            int worstIndex = -1;
            
            
            for(int j=0; j<m; j++){
                
                if(bl[j] >= pr[i]){
                    
                    if(worstIndex==-1){ worstIndex = j; }
                    else if(bl[worstIndex] < bl[j]){ worstIndex = j; }
                    
                }   // if
            
            }   // for - j
            
            
            if(worstIndex != -1){
                all[i] = worstIndex;
                bl[worstIndex] -=pr[i];
            }   // if
            
            
            
            // System.out.println();
            // for(int k=0; k<m; k++){
            //     System.out.print("\t"+bl[k]);
            // }   // for - k
            // System.out.println();
            
            
            
        }   // for - i
        
        System.out.println("Process No. \t Process Size \t Block Number");
        for(int i=0; i<n; i++){
            
            System.out.println((i+1)+"\t\t"+pr[i]+"\t\t"+( (all[i]==-1) ?"Not Allocated": all[i]));
            
        }   // for - i
        
        
    }   // worstFit()
    
    
    
    
    
	public static void main(String[] args) {
	    
	    int blockSize[] = {100, 500, 200, 300, 600};
	    int processes[] = {212, 417, 112, 426};
	    int m = blockSize.length;
	    int n = processes.length;
	   // bestFit(blockSize, m, processes, n);
	   //firstFit(blockSize, m, processes, n);
	   //nextFit(blockSize, m, processes, n);
		worstFit(blockSize, m, processes, n);
		
		
	}   // psvm()
}   // Fits
