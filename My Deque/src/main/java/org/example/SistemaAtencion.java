package org.example;

class SistemaAtencion {
    private MyDeque<String> cola;

    public SistemaAtencion(){
        cola = new MyDeque<>();
    }

    public void procesarEvento(String eventos){
        String[] partes = eventos.split(" ");

        switch (partes[0]){

            case "NORMAL":
                cola.addLast(partes[1]);
                break;

            case "PRIORITARIO":
                cola.addFirst(partes[1]);
                break;

            case "ATENDER":
                String atendido = cola.removeFirst();
                System.out.println("Atendido: " + atendido);
                break;

            case "CANCELAR_ULTIMO":
                String eliminado = cola.removeLast();
                System.out.println("Cancelado: " + eliminado);
                break;
        }

        cola.mostrar();
    }
}