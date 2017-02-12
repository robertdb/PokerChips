package ram.pokerChips.modelo.linkedList;

/**
 * Created by Robert on 20/1/17.
 */

public class IteradorListaCircular {

    private ListaCircular listCircular;
    private ListNode actual;


    public IteradorListaCircular(ListaCircular list){

        listCircular = list;
        actual = listCircular.getFirst();

    }

    private ListNode buscarActual(Object data){
        for (int i = 0; i < listCircular.size() ; i++) {
            if (listCircular.getNodeAt(i).data == data){
                return listCircular.getNodeAt(i);
            }
        }
        return null;
    }
    public IteradorListaCircular(ListaCircular list, Object data){

        listCircular = list;
        actual = buscarActual(data);

    }

    public boolean haySiguiente() {
        return (listCircular.size() > 0);
    }

    public Object actual() {
        if(actual == null  || listCircular.size() == 0)
            throw new UnsupportedOperationException();
        return actual.data;
    }

    public Object siguiente() {
        if(actual == null || actual.next == null)
            throw new UnsupportedOperationException();
        actual = actual.next;
        return actual.data;
    }


    public void removerActual() {
        if(listCircular.size() == 0)
            throw new UnsupportedOperationException();

        if(listCircular.size() == 1){
            listCircular.removeAtFirst();
        }else
        if(actual == listCircular.getFirst()){
            // si se borra el primero, el siguiente pasa a ser el primero.
            //actual = listCircular.getFirst().siguiente;
            actual = listCircular.getLast();
            listCircular.removeAtFirst();
        }else
        if(actual == listCircular.getLast()){
            // si se borra el ultimo, el actual es el primero.
            //actual = listCircular.getFirst();
            //listCircular.removeAtLast();

            actual = listCircular.getNodeAt(listCircular.size() - 2);
            listCircular.removeAtLast();
        }else{
            //ListNode aux  = actual.siguiente;
            //listCircular.removeAt(listCircular.findPositionElement(actual.data));
            //actual = aux;

            int position = listCircular.findPositionElement(actual.data);
            actual = listCircular.getNodeAt(position -1);
            listCircular.removeAt(position);

        }
    }

    public void moverActual(Object data) {

        this.actual = buscarActual(data);

    }

    public Object verSiguiente() {

        return actual.next.data;

    }

    public int listaSize(){
        return listCircular.size();
    }
}
