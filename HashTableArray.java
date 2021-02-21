public class HashTableArray {
    private Student[] hashTable;
    HashTableArray(){
        hashTable= new Student[10];
    }
    private int hash(String name){
        int hash= name.length()%hashTable.length;
        return hash;
    }
    private boolean occupied(int ind){
        return hashTable[ind]!=null;
    }
    void insert(Student student){           //Here we are first checking the index at hash(key) and if the space is not empty, we are checking linearly throughout the array for empty space. First after the given hashed position and then from start to the given hashed position
        int hash= hash(student.name);
        int stop= hash;
        if(occupied(hash)){
            while(hash!=hashTable.length-1){
                hash++;
                if(!occupied(hash)){
                    break;
                }
            }
            if(hash==hashTable.length-1&&occupied(hash)){
                hash=0;
                while(hash!=stop){
                    if(!occupied(hash)){
                        break;
                    }
                    hash++;
                }
            }
        }
        if(hash==stop&&occupied(hash)){
            System.out.println("The hashtable is full");
        }
        else{
            hashTable[hash]= student;
        }
    }
    void display(){
        for(int i=0; i<hashTable.length; i++){
            try{
                System.out.println(hashTable[i].name+":"+hashTable[i].gpa);
            }
            catch (NullPointerException e){}
        }
    }
    Student get(String key){                        //The same checking stuff is done on the get method.
        try {
            int hash= hash(key);
            int stop= hash;
            if(hashTable[hash].name.equals(key)){
                return hashTable[hash];
            }
            else{
                while (hash!=hashTable.length-1){
                    hash++;
                    if(hashTable[hash].name.equals(key)){
                        return hashTable[hash];
                    }
                }
                if(hash==hashTable.length-1){
                    hash=0;
                    while(hash!=stop){
                        if(hashTable[hash].name.equals(key)){
                            return hashTable[hash];
                        }
                        hash++;
                    }
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("not found");
        }
        return null;
    }
    Student remove(String key){
        try {
            int hash= hash(key);
            int stop= hash;
            if(hashTable[hash].name.equals(key)){
                Student student= hashTable[hash];
                hashTable[hash]= null;
                return student;
            }
            else{
                while (hash!=hashTable.length-1){
                    hash++;
                    if(hashTable[hash].name.equals(key)){
                        Student student= hashTable[hash];
                        hashTable[hash]= null;
                        return student;
                    }
                }
                if(hash==hashTable.length-1){
                    hash=0;
                    while(hash!=stop){
                        if(hashTable[hash].name.equals(key)){
                            Student student= hashTable[hash];
                            hashTable[hash]= null;
                            return student;
                        }
                        hash++;
                    }
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("not found");
        }
        return null;
    }
}
