import java.util.*;

public class Main 
{
    static ArrayList<customer> cus=new ArrayList<>();
    static ArrayList<product> pro=new ArrayList<>();
    static ArrayList<billdetail> bill=new ArrayList<>();
    static class customer
    {
        int id;
        String name,phone_no;
        customer(int id,String name,String phno)
        {
            this.id=id;
            this.name=name;
            this.phone_no=phno;
        }
    }
    static class product
    {
        int pro_id,price;
        String name;
        product(int id,String name,int price)
        {
            this.pro_id=id;
            this.name=name;
            this.price=price;
        }
    }
    static class bill
    {
        int id,cus_id,tot_qty;
        String date;
        float amt;
        bill(int id,String date,int cid,int qty,float amt)
        {
            
        }
    }
    static class billdetail
    {
        int id,cus_id;
        static HashMap<String,Integer> pro_details; //key-product name value-quantity
        static HashMap<String,Integer> pro_pri;
        static float price;
        static int pp=0;
        billdetail(int id,int cid,HashMap<String,Integer> prod)
        {
            this.id=id;
            this.cus_id=cid;
            this.pro_details=prod;
        }
        static float get_price()
        {
            price=0;
            for(Map.Entry<String,Integer> e:pro_details.entrySet())
            {
                pp=0;
                for(int i=0;i<pro.size();i++)
                {
                    if(e.getKey().equals(pro.get(i).name))
                    {
                        pp=pro.get(i).price*e.getValue();
                        pro_pri.put(e.getKey(),pp);
                    }
                }
                price+=pp;
            }
            return price;
        }
    }
   
    public static void main(String a[])
    {
        customer c[]=new customer[5];
        c[0]=new customer(1,"anbu","9999955555");
        c[1]=new customer(2,"karthi","1234554321");
        c[2]=new customer(3,"dinesh","5432112345");
        c[3]=new customer(4,"prabhu","9876556789");
        c[4]=new customer(4,"viki","9876543210");
        for(int i=0;i<5;i++)
            cus.add(c[i]);
            
        product p[]=new product[5];
        p[0]=new product(1,"dove",50);
        p[1]=new product(2,"haamam",100);
        p[2]=new product(3,"cinthol",35);
        p[3]=new product(4,"sandal",77);
        p[4]=new product(5,"lux",99);
        for(int i=0;i<5;i++)
            pro.add(p[i]);
        
        billdetail bd[]=new billdetail[3];
        HashMap<String,Integer> hp=new HashMap<>();
        hp.put(pro.get(0).name,2);
        hp.put(pro.get(3).name,1);
        hp.put(pro.get(4).name,4);
        bd[0]=new billdetail(1,cus.get(0).id,hp);
        bill.add(bd[0]);
        for(int i=0;i<bill.size();i++)
        {
            billdetail bds=bill.get(i);
            System.out.println("Bill_id:"+bds.id);
            System.out.println("customer_id:"+bds.cus_id);
            String name="";
            for(i=0;i<cus.size();i++)
            {
                if(bds.cus_id==cus.get(i).id)
                    name=cus.get(i).name;
            }
            System.out.println("customer_name: "+name);
            int cc=0;
            for(Map.Entry<String,Integer> e:bds.pro_details.entrySet())
            {
                System.out.println(++cc+". "+e.getKey()+" "+e.getValue());//+" "+bds.pro_pri.get(e.getKey()));
            }
            //System.out.println("Total Amount - "+bds.get_price());
        }
        
        for(int i=0;i<cus.size();i++)
        {
            customer res=cus.get(i);
            System.out.println(res.id+" "+res.name+" "+res.phone_no);
        }
        
    }
}