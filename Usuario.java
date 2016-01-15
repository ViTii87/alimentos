import java.util.ArrayList;
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
   //Atributo que guardara el nombre completo de la persona .
   private String nombreCompleto;
   //Atributo que guardara el total de las proteinas ingeridas.
   private float proteinasIngeridas;
   //Atributo que guardara el total de las carbohidratos ingeridas.
   private float carbohidratosIngeridos;
   //Atributo que guardara el total de las grasas ingeridas.
   private float grasasIngeridas;
   //Atributo para guardar las calorias totales del usuario.
   private float caloriasUsuario;
   //Atributo que nos permite guardar el alimento mas calorico
   private Alimento masCalorico;
   //Atributo de tipo ArrayList que nos permitira guardar los alimentos en el orden ingerido
   private ArrayList<Alimento> arrayDeAlimentos;
   
   /**
    * Constructor que crea usuarios.
    */
   public Usuario(String nombreCompleto){
       this.nombreCompleto = nombreCompleto;
       proteinasIngeridas = 0;
       carbohidratosIngeridos = 0;
       grasasIngeridas = 0;
       caloriasUsuario = 0;
       masCalorico = null;
       arrayDeAlimentos = new ArrayList<Alimento>();
   }
   
   /**
    * Metodo para que el usuario pueda comer alimentos
    */
   public void comer(Alimento comida, float cantidad){
       proteinasIngeridas = proteinasIngeridas + (comida.getProteinas() * (cantidad/100));
       carbohidratosIngeridos = carbohidratosIngeridos + (comida.getCarbohidratos() * (cantidad/100));
       grasasIngeridas = grasasIngeridas + (comida.getGrasas() * (cantidad/100));
       caloriasUsuario = caloriasUsuario + (comida.getCalorias() * (cantidad/100));
       
       //Añadimos el alimento a nuestro array de alimentos.
       arrayDeAlimentos.add(comida);
       
       //Comprobamos si hay algun alimentos mas calorico o si el ingerido es mayor que el que habia.
       if(masCalorico==null || comida.getCalorias() >= masCalorico.getCalorias()){
           masCalorico = comida;
        }
   }
   
   /**
    * Metodo para mostrar los datos del usuario
    */
   public void mostrarDatos(){
       if(proteinasIngeridas!=0 || carbohidratosIngeridos!=0 || grasasIngeridas!=0){
           float totalGramos = proteinasIngeridas + carbohidratosIngeridos + grasasIngeridas;
           System.out.println("Nombre: \t\t\t\t\t" + nombreCompleto);
           System.out.println("Gramos totales de proteinas ingeridos: \t\t" + proteinasIngeridas + "(" + ((proteinasIngeridas/totalGramos)*100) + "%)");
           System.out.println("Gramos totales de carbohidratos ingeridos: \t" + carbohidratosIngeridos + "(" + ((carbohidratosIngeridos/totalGramos)*100) + "%)");
           System.out.println("Gramos totales de grasas ingeridos: \t\t" + grasasIngeridas + "(" + ((grasasIngeridas/totalGramos)*100) + "%)");
           System.out.println("Calorias totales ingeridas: \t\t\t" + caloriasUsuario);
       }
       else{
           System.out.println("Nombre: \t\t\t\t\t" + nombreCompleto);
           System.out.println("Gramos totales de proteinas ingeridos: \t\t" + proteinasIngeridas);
           System.out.println("Gramos totales de carbohidratos ingeridos: \t" + carbohidratosIngeridos);
           System.out.println("Gramos totales de grasas ingeridos: \t\t" + grasasIngeridas);
           System.out.println("Calorias totales ingeridas: \t\t\t" + caloriasUsuario);
       }
   }
   
   /**
    * Metodo que nos devolvera las calorias totales de nuestro usuario.
    */
   public float getCaloriasTotales(){
       return caloriasUsuario;
   }
   
   /**
   * Metodo que nos devolvera el nombre de nuestro usuario.
   */
   public String getNombreCompleto(){
       return nombreCompleto;
   }
   
   /**
    * Metodo que compara las calorias de dos usurios e indica que el de ellos ha consumido mas.
    * Le pasamos por parametro el segundo usuario con el que queremos comparar.
    */
   public void comparaCalorias(Usuario usuario2){
       String comparacion;
       comparacion = getNombreCompleto() + " ha consumido más calorias que " + usuario2.getNombreCompleto() + " (" + getCaloriasTotales() 
       + " frente a " + usuario2.getCaloriasTotales() + ")";
       if(getCaloriasTotales() < usuario2.getCaloriasTotales()){
           comparacion = usuario2.getNombreCompleto() + " ha consumido más calorias que " + getNombreCompleto() + " (" + usuario2.getCaloriasTotales() 
           + " frente a " + getCaloriasTotales() + ")";
       }
       else if(getCaloriasTotales() == usuario2.getCaloriasTotales()){
               comparacion = getNombreCompleto() + " ha consumido las mismas calorias que " + usuario2.getNombreCompleto() 
               + " (" + getCaloriasTotales() + ")";
       }
       System.out.println(comparacion);
    }
   
    /**
     * Metodo que nos imprimira por pantalla el nombre del alimento mas calorico y sus calorias por cada 100 gramos
     */
   public void alimentoMasCalorico(){
       if(masCalorico == null){
           System.out.println("Todavia no se ha ingerido ningun alimento.");
       }
       else {
           System.out.println("Alimento mas calorico ingerido por este usuario hasta el momento: " + masCalorico.getName() + " (" + masCalorico.getCalorias() +
           " calorias por cada 100 gramos)");
       }
   }
   
   /**
    * Metodo que nos permitira visualizar en el orden ingerido por el usuario un alimento. 
    */
   public void posicionAlimentoIngerido(int index){
       int indiceArray=0;
       boolean buscando = true;
       //Hacemos esta comprobacion para mostrar un mensaje de error si introducimos un indice incorrecto.
       if(index < arrayDeAlimentos.size() && index > -1){
           //Recorremos nuestro array hasta que encontremos el indice buscado, entonces lo paramos
           while(indiceArray < arrayDeAlimentos.size() && buscando){
               if(index == indiceArray){
                   buscando = false;
                }
                else{
                    indiceArray += 1;
               }
            }
       }
       else{
           System.out.println("Indice introducido incorrecto, no existen alimentos en esa posicion");
       }
       //Como hemos encontrado elemento, mostramos los datos.
       if(buscando == false){
           arrayDeAlimentos.get(index).muestraDatos();
       }
   }
}
