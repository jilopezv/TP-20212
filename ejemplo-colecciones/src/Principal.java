import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Collection c = new Vector();

        Collection<Integer> c2 = new LinkedList<>();

        c.add('5');
        c.add("Hola");
        c.add('c');

        c2.add(3);
        c2.add(3);
        c2.add(3);
        c2.add(3);
        // c2.add("String");

        c.addAll(c2);

        List cConvertida = (List) c;
        cConvertida.add(0, "Primer elemento");


        Collection<Integer> conjunto = new TreeSet<Integer>();
        conjunto.add(3);
        conjunto.add(3);
        conjunto.add(3);

        Queue<Double> cola = new LinkedList<Double>();
        cola.add(2.3);
        cola.add(4.3);
        cola.add(2.3);
        cola.add(3.5);

        System.out.println(cola.remove());
        System.out.println(cola.peek());
        System.out.println(cola.remove());
        System.out.println(cola.poll());
        System.out.println(cola.remove());
        System.out.println(cola.poll());

        Stack<String> pila = new Stack<>();
        pila.push("hola");
        pila.push("buenos días");
        pila.push("buenas tardes");
        pila.push("buenas noches");

        System.out.println(pila.peek());
        System.out.println(pila.pop());
        System.out.println(pila.pop());

        Map<String, String> mapa = new HashMap<>();
        mapa.put("123", "Juan");
        mapa.put("341", "María");
        mapa.put("654", "Hernán");
        mapa.put("111", "pedro");

        System.out.println(mapa.get("341"));
        System.out.println(mapa.get("124"));
        mapa.put("341", "Sara");
        System.out.println(mapa.get("341"));
        System.out.println(mapa.remove("111"));


        Map<Integer, Estudiante> mapaEstudiantes = new HashMap();
        Estudiante e1 = new Estudiante(111, "123", "Mateo");
        Estudiante e2 = new Estudiante(222, "456", "Diana");
        Estudiante e3 = new Estudiante(333, "789", "Jorge");
        mapaEstudiantes.put(e1.getNumeroCarnet(), e1);
        mapaEstudiantes.put(e2.getNumeroCarnet(), e2);
        mapaEstudiantes.put(e3.getNumeroCarnet(), e3);

        System.out.println(mapaEstudiantes.get(111));




    }
}
