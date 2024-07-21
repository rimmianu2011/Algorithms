import java.util.Scanner;

/*
 * @author : Anushka Yadav
 */

public class Planters {
	int h1[];
	int h2[];
	int sizeofh1;
	int sizeofh2;
	int h1MaxSize;
	int h2MaxSize;
	
	Planters(int h1MaxSize,int h2MaxSize){
		this.h1MaxSize = h1MaxSize;
		this.h2MaxSize = h2MaxSize;
		this.sizeofh1 = 0;
		this.sizeofh2 = 0;
		this.h1 = new int[h1MaxSize];
		this.h2 = new int[h2MaxSize];
	}
	
	public void insertoH1(int element) {
		
		h1[sizeofh1] = element;
		
		int current = sizeofh1;
		while(h1[current] > h1[parent(current)]) {
			swapforh1(current,parent(current));
			current = parent(current);
		}
		sizeofh1++;
		
		
	}
	public void insertoH2(int element) {
		
		h2[sizeofh2] = element;
		
		int current = sizeofh2;
		while(h2[current] > h2[parent(current)]) {
			swapforh2(current,parent(current));
			current = parent(current);
		}
		sizeofh2++;
		
		
	}

	public int parent(int i) {
		return (i-1)/2; //use math.floor
	}
	
	public int getLeftChild(int i) {
		return (2*i+1);
	}
	
	public int getRightChild(int i) {
		return (2*i+2);
	}
	
	public void swapforh1(int firstNode, int secondNode) {
		int temp;
		temp = h1[firstNode];
		h1[firstNode] = h1[secondNode];
		h1[secondNode] = temp;
	}

	public void swapforh2(int firstNode, int secondNode) {
		int temp;
		temp = h2[firstNode];
		h2[firstNode] = h2[secondNode];
		h2[secondNode] = temp;
	}
	
	public void maxHeapifyforH1(int i) {
		if (isLeaf(i))
            return;
		
		if(h1[i] < h1[getLeftChild(i)] || h1[i] < h1[getRightChild(i)]) {
			if(h1[getLeftChild(i)] > h1[getRightChild(i)]) {
				swapforh1(i, getLeftChild(i));
				maxHeapifyforH1(getLeftChild(i));
			}
			else if (h1[getRightChild(i)] > h1[getLeftChild(i)]) {
				swapforh1(i,getRightChild(i));
				maxHeapifyforH1(getRightChild(i));
			}
			else if(h1[getLeftChild(i)] == h1[getRightChild(i)]) {
				swapforh1(i,getLeftChild(i));
				maxHeapifyforH1(getLeftChild(i));
			}
			
		}
	
	}
	public void maxHeapifyforH2(int i) {
		
		if(h2[i] < h2[getLeftChild(i)] || h2[i] < h2[getRightChild(i)]) {
			if(h2[getLeftChild(i)] > h2[getRightChild(i)]) {
				swapforh2(i, getLeftChild(i));
				maxHeapifyforH2(getLeftChild(i));
			}
			else if (h2[getRightChild(i)] > h2[getLeftChild(i)]) {
				swapforh2(i,getRightChild(i));
				maxHeapifyforH2(getRightChild(i));
			}
			else if(h2[getLeftChild(i)] == h2[getRightChild(i)]) {
				swapforh2(i,getLeftChild(i));
				maxHeapifyforH2(getLeftChild(i));
			}
			
		}
	
	}
	
	private boolean isLeaf(int i)
    {
        if (i > (sizeofh1 / 2) && i <= sizeofh1) {
            return true;
        }
        
        return false;
    }
	
	
	public int extractMaxforH1() {
		int popped = h1[0]; 
		h1[0] = h1[--sizeofh1];
		
		maxHeapifyforH1(0);
		return popped;
	}
	public int extractMaxforH2() {
		int popped = h2[0]; 
		h2[0] = h2[--sizeofh2];
		maxHeapifyforH2(0);
		return popped;
	}
	
	
	public String canBeReplanted() {
		String answer = "YES";
		int popped = 0, popped2 =0, count=0;
		while(sizeofh1 != 0) {
			if(h1[0] < popped) {
				//within the heap
				count++;
				popped = extractMaxforH1();
				sizeofh1--;
			}
			else if(h1[0] < h2[0]) {
				popped = extractMaxforH1();
				popped2 = extractMaxforH2();
				count++;
				sizeofh1--;
				sizeofh2--;
				
			}
			else if(h1[0] == h2[0]) {
				answer = "NO";
				break;
			}
			else if(h1[0] == popped) {
				if(h1[0] < h2[0]) {
					popped = extractMaxforH1();
					popped2 = extractMaxforH2();
					count++;
					sizeofh1--;
					sizeofh2--;
				}
				
			}
			else if(h1[0] == popped || h1[0] > popped && h1[0] < h2[0]) {
				popped = extractMaxforH1();
				popped2 = extractMaxforH2();
				count++;
				sizeofh1--;
				sizeofh2--;
			}
		}
		if(count != sizeofh1) {
			answer = "NO";
		}
		
		return answer;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int r = sc.nextInt();
				
		Planters plant = new Planters(2500000,2500000);
		
		for(int i=0;i<p;i++) {
			plant.insertoH1(sc.nextInt());
		}
		
		for(int i=0;i<r;i++) {
			plant.insertoH2(sc.nextInt());
		}
		
		String answer = plant.canBeReplanted();
		System.out.println(answer);
		sc.close();

	}
	
}
