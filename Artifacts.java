class App{
    public static void main(String[] args){
        int n=Integer.parseInt(args[0]);
        String movement=args[1];
        String condition=args[2];

        int p=0;
        int s=0;
        for(int i=0; i<=n; i++){
            double j=Math.random();
            if(j<0.5)
                p++;
            else 
                s++;
        }
        Paintings[] paints=new Paintings[p];
        Sculptures[] sculpts=new Sculptures[s];
        int a=p+s;
        Artifacts[] arts=new Artifacts[a];

        for(int i=0; i<=p; i++){
            arts[i]=paints[i];
        }
        for(int j=p+1; j<=a; j++){
            int i=0;
            arts[j]=sculpts[i];
            i++;
        }

        auction(arts, movement, condition);
    }

    static void auction(Artifacts[] arts, String movem, String cond){
        for(int i=0; i<=arts.length; i++){
            arts[i].getIndex();
            arts[i].getInfo();
            Paintings.evaluate(movem, cond);
        }
    }
}

class Artifacts{
    int index;
    String creator;
    int year;

    Artifacts(){
        System.out.println("Creating an instance of Artifacts");   
    }

    void getInfo(){
        System.out.println("Creator:" + creator);
        System.out.println("Year of creating:" + year);
    }

    void getIndex(){
        System.out.println("Index:" + index);
    }
}

class Masterpiece extends Artifacts{
    String movement; //impressionism, expressionism, naturalism
    String condition; //bad, good, excellent

    Masterpiece(){
        System.out.println("Creating an instance of Masterpiece");   
    }

    void getInfo(){
        getInfo();
        System.out.println("Movement:" + movement);
        System.out.println("Condition:" + condition);
    }
}

class Paintings extends Masterpiece{
    int length;
    int width;
    String technique; //oil, aquarelle, tempera

    Paintings(){
        System.out.println("Creating an instance of Paintings");   
    }

    void getInfo(){
        getInfo();
        System.out.println("Length:" + length);
        System.out.println("Width:" + width);
        System.out.println("Technique:" + technique);
        int surface=length*width;
        System.out.println("Surface:" + surface);
    }

    static boolean evaluate(String movement, String condition){
        if(condition=="bad" || condition=="good" || condition=="excellent")
            if(movement=="impressionism" || movement=="expressionism" || movement=="naturalism")
                return true;
            else
                return false;
        else if(condition==null){
            condition="good";
            if(movement=="impressionism" || movement=="expressionism" || movement=="naturalism")
                return true;
            else
                return false;
        }
        else 
            return false;
    }
}

class Sculptures extends Masterpiece{
    int volume;
    String material;  //iron, stone, wood

    Sculptures(){
        System.out.println("Creating an instance of Sculptures");   
    }

    void getInfo(){
        getInfo();
        System.out.println("Volume:" + volume);
        System.out.println("Material:" + material);
    }
    
    static boolean evaluate(String movement, String condition){
        if(condition=="bad" || condition=="good" || condition=="excellent")
            if(movement=="impressionism" || movement=="expressionism" || movement=="naturalism")
                return true;
            else
                return false;
        else if(condition==null){
            condition="good";
            if(movement=="impressionism" || movement=="expressionism" || movement=="naturalism")
                return true;
            else
                return false;
        }
        else 
            return false;
    }
}