package HashTableDS;
/*
Notes:
func2 returns step size
index + stepSize = newIndex
newIndex % arraySize = newIndex to be checked
*/
public class HashTable {
    String[] hashArray;
    int arraySize;
    int size = 0; //Counter for # of elements in the hash table

    public HashTable(int numOfSlots){ //num of slots must be a prime number

        if(isPrime(numOfSlots)){
            hashArray = new String[numOfSlots];
            arraySize = numOfSlots;
        }
        else{
            numOfSlots = getNextPrime(numOfSlots);
            hashArray = new String[numOfSlots];
            arraySize = numOfSlots;

            System.out.println("Hash Table size given was not prime.");
            System.out.println("Hash Table size changed to " + numOfSlots);
        }
    }
    private boolean isPrime(int num){
        for(int i = 2; i*i < num; i++){ //only needs to reach half the value of num to verify prime
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    private int getNextPrime(int minNumber){
        for(int i = minNumber; true; i++){ //Starts at minNumber and increments until the if statement is true
            if(isPrime(i))
                return i;
        }
    }
    private int getPreviousPrime(int minNumber){
        for(int i = minNumber - 1; true; i--){ //Starts at minNumber and decrements until the if statement is true
            if(isPrime(i))
                return i;
        }
    }
    //returns preferred index position
    private int hashFunc1(String word){
        int hashVal = word.hashCode();
        hashVal %= arraySize;
        if(hashVal < 0){
            hashVal += arraySize;
        }
        return hashVal; //ideal index position we'd like to insert or search in (objective of this method)
    }
    //returns step size greater than 0
    private int hashFunc2(String word){ 
        int hashVal = word.hashCode();
        hashVal %= arraySize;
        if(hashVal < 0){
            hashVal += arraySize;
        }
        int smallerPrimeNum = getPreviousPrime(arraySize);
        return smallerPrimeNum - hashVal % smallerPrimeNum;
    }
    public void insert(String word){
        int preferredIndex = hashFunc1(word);
        int stepSize = hashFunc2(word);
        while(hashArray[preferredIndex] != null){
            preferredIndex += stepSize;
            preferredIndex %= arraySize;
        }
        hashArray[preferredIndex] = word;
        System.out.println("Inserted word: " + word);
        size++;
    }
    public String find(String word){
        int preferredIndex = hashFunc1(word);
        int stepSize = hashFunc2(word);
        while(hashArray[preferredIndex] != null){
            if(hashArray[preferredIndex].equals(word)){
                return hashArray[preferredIndex];
            }
            preferredIndex += stepSize;
            preferredIndex %= arraySize;  
        }
        return hashArray[preferredIndex];
    }
    public void displayTable(){
        System.out.println("Table: ");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null){
                System.out.print(hashArray[i] + " ");
            }
            else{
                System.out.print("** ");
            }
            System.out.println("");
        }
    }
}