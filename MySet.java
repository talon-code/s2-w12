public class MySet{
    private int[] myElements;
    private int myElementCount;

    public MySet(int count){
        myElements = new int[count];
        myElementCount = count;
        for(int x = 0; x < count; x++){
            myElements[x] = x * 10;
        }
        System.out.println(this);
        boolean isIn = contains(10);
        System.out.println(isIn);
         isIn = remove(10);
        System.out.println(isIn);
        isIn = contains(132);
        System.out.println(isIn);
    }

    public boolean contains(int x){
        return containsHelper(x, 0);
    }

    public boolean containsHelper(int value, int index){
        if(index == myElementCount)
            return false;
        else if(value == myElements[index])
            return true;
       return containsHelper(value, index+1);
    }

    public boolean remove(int x){
        return removeHelper(x, 0, false);
    }

    public boolean removeHelper(int value, int index, boolean removed){
        if(index == myElementCount){
            if(removed)
                return true;
            return false;
        }else if(value == myElements[index]){
            for(int i = index; i < myElementCount - 1; i++)
                myElements[i] = myElements[i+1];
            index--;
            removed = true;
        }
        return removeHelper(value, index + 1, removed);
    }
    
    public String toString(){
        return myElements.toString();
    }

    public static void main(String[] args) {
        MySet m = new MySet(10);

    }
}