# *BIENVENIDOS A NUESTRO PROYECTO DE ZOOLOGICO*
![me](https://static.vecteezy.com/system/resources/previews/008/615/594/non_2x/zoo-animals-group-in-flat-cartoon-style-free-vector.jpg) 




**Zoológico** :shipit:

*En este proyecto desarrollamos un sistema de gestión para un zoológico, que abarca diversas funcionalidades para asegurar el bienestar de los animales, la comodidad de los visitantes y el funcionamiento eficiente de las operaciones diarias. El programa está preparado para la comodidad tanto de los animales como la de los visitantes, se pueden manejar diversas funcionalidades de ambos al igual que las demás personas de el zoológico.
Para garantizar el cuidado óptimo de los animales al igual que su alimentación, el programa permite registrar información detallada sobre cada especie y su hábitat (como por ejemplo aclarar que es un mamífero el cual esta en un habitat específico, por ejemplo los monos se encontrarían solo con los monos) así como llevar un seguimiento de la salud de los animales individualmente (de esta forma podemos conocer si se enfermo por algún cambio en su temperatura corporal o porque fue alimentado de una forma que no debía).
A su vez, las tiendas dentro del zoológico ofrecen una amplia gama de comidas para los visitantes, y el programa administra si está el correspondiente stock para que el visitante pueda consumir el alimento deseado.
De los visitantes también podemos visualizar que pueden entrar en grupos o solitarios, ya que podría entrar un menor de edad y para eso necesita a sus padres o a algún adulto mayor a los 18 años. También pueden acceder a las diferentes atracciones (como por ejemplo ver a los animales) solamente si pagaron antes el boleto, en caso de no tenerlo no deberían poder disfrutar de ninguna de las instalaciones.
El hospital veterinario está equipado para proporcionar atención médica a los animales enfermos por una comida incorrecta, con un registro de que animal fue tratado y por cual veterinario fue tratado.
Los veterinarios son asignados a diferentes áreas del zoológico, ya que deberán alimentar a los animales y también curarlos.
Por último, el personal de mantenimiento se encarga de mantener las instalaciones limpias y en buen estado, el cual debe revisar por ejemplo, que el zoológico no esté sucio o que una estructura (habitat) no esté roto.
En resumen, nuestro objetivo es crear un proyecto integral que optimice la gestión de un zoológico, asegurando la satisfacción de los visitantes y el bienestar de los animales, mientras se mantiene un funcionamiento eficiente de todas las operaciones.*

### -- EXPLICACIÓN DE LOS TEST DE ARIAS SOL --

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerSiElPesoDelAnimalAumentoAlSerAlimentadoConSuComidaCorrespondiente();
En este test analizamos los registros de alimentación ingresados, los cuales solamente se crean si se alimento de una forma "correcta" al animal, ya que podria ser que el veterinario se confunda y al ser animales en cautiverio, comen de igual forma esa comida (CARNE O PLANTA). Una vez alimentado debemos consultar su peso para averiguar si realmente comio lo que debia y si engordo por esa comida.*

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosRegistrosQueContenganUnAnimalEspecifico();*
En este test volveremos a analizar dichos registros y buscaremos en cada uno de ellos si se encuentra el animal que esperamos que este alli adentro, en caso de que este lo agregamos a una lista para luego ser analizada si fue agregado de forma correcta.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConCarne();*
- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConPlantas();*
En estos test volveremos a analizar los registros para consultar si la comida que le dio el veterinario fue carne o plantas, en el caso de que sea asi, cada lista guarda su respectivo animal para ser analizado.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico();*
En este test deberiamos obtener aquellos veterinarios que alimentaron por ejemplo a un Mono, consultaremos en cada registro si ese registro contiene a este animal para poder guardar luego la persona de ese registro (fue ingresado como persona para poder trabajar con instanceof de una manera más comoda, lo que me parecio más correcto) y enseñarla en el test correspondiente.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosAnimalesQueAlimentoUnVeterinarioEspecifico();*
Realiza la misma acción que el anterior solo que aca buscamos aquellos animales que fueron alimentados por un veterinario especifico.

- *dadoQueExisteUnZoologicoConAnimalesConocerALosQueSeEnfermaronPorHaberSidoAlimentadosConComidaNoApta();*
Aca profundizo en saber su estado de enfermedad, comprobandolo ya que los registros aunque esten "mal" (que el veterinario confunda el alimento) deben ser registrados para conocer que fue alimentado con algo que no debe, por ese motivo esta enfermo. Ya que si el animal se enferma por algo externo no deberia ser aceptado en este test.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearElRegistroSiUnPersonalNoAutorizadoQuiereAlimentarAlAnimal();*
El test busca usar el instanceof, ya que al recibir el registro una persona nosotros tenemos que VERIFICAR que sea un veterinario, en caso de no serlo tendremos una excepcion ya realizada en el mismo test.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElAnimalEsInexistente();*
- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElVeterinarioEsInexistente();*
En los test buscamos que no sea nulo el animal/veterinario o que no se haya agregado, de estos test tambien esperamos una excepcion ya colocada.

- *dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueSeCreeUnRegistroCuandoUnVeterinarioAlimenteDeFormaCorrectaAlAnimal();*
En este test creamos de forma correcta el registro, ingresando todos los datos de forma correcta y teniendo todas las validaciones correctas.

- *dadoQueExisteUnZoologicoQueAlHacerseDeDiaSeDespiertenLosAnimales();*
- *dadoQueExisteUnZoologicoQueAlHacerseDeNocheLosAnimalesSeDuerman();*
En estos test dependiendo la hora que sea el zoologico la cual es seteada podemos conocer si los animales se durmieron o estan despiertos, por ejemplo si el horario fuera 09:00 estarian despiertos, caso de que sean las 22:00 estan dormidos ya que seria el horario que estaria inactivo el zoo.

- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarUnVeterinarioInexistente();*
- *dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarAUnHospitalInexistente();*
En estos test corroboramos que exista ese veterinario/hospital, pero esto claramente nos daria una excepcion ya que no podriamos meter a un veterinario que no se encuentre en el zoo ni tratar de meter a un veterinario en una estructura que no existe.

- *dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarEnOtraEstructuraQueNoSeaUnHospital();*
- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarOtroPersonalQueNoSeaVeterinario();*
Debemos corroborar que el hospital sea donde entra el veterinario, ya que seria un error si queremos meterlo en el habitat de los animales por ejemplo. A su vez seria incorrecto meter a uno de mantenimiento o un visitante en el hospital ya que no sabrian como curar o manejarse dentro de el.

- *dadoQueExisteUnZoologicoConVeterinarioQueSePuedaAgregarAUnHospital();*
En este test se agregara de forma correcta ese veterinario ya que soportaria todas las validaciones para poder ingresar.

- *dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesEnfermosDeSaludPorBajaTemperaturaCorporal();*
- *dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesConTemperaturaCorporalNeutral();*
En estos test debemos trabajar con la temperatura de los animales, por defecto ya tienen una temperatura la cual estarian bien con ella, pero si se pasa de ella (al setearlo) pasara a estar enfermo por ello.

- *dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionHerbivora();*
- *dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionCarnivora();*
- *dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionOmnivora();*
En estos tres test simplemente buscaremos en la lista del zoo aquel tipo de alimentacion que tengan para poder meterlo en la lista y mostrarlo en un test.

- *dadoQueExisteUnZoologicoQueNoSePuedanAgregarEstructurasAlMismoSiEstaNoExiste();*
- *dadoQueExisteUnZoologicoQueNoSePuedanAgregarPersonasAlMismoSiEstaNoExiste();*
- *dadoQueExisteUnZoologicoQueNoSePuedanAgregarAnimalInexistente();*
Simplemente tendremos que esperar excepciones ya que por algun motivo no pueden ser agregados (por ser inexistentes-> nulos).


### -- EXPLICACIÓN DE LOS TEST DE GOMEZ JIMENA --

- *dadoQueExisteUnZoologicoNoSePuedenAgregarPersonasSiEstasSonMenores();*
Al intentar agregar a una persona sola (es decir, no en grupo) y que esta sea menor de 18 años, se lanzará una excepción de tipo NoSePuedenAgregarMenoresDeEdadException. Esto se debe a que, los empleados (veterinarios y de mantenimiento) no pueden trabajar siendo menores, y los visitantes pueden ingresar solos si es que son mayores. Los menores solo pueden ingresar acompañados de al menos un mayor.

- *dadoQueExisteUnZoologicoConAnimalesEstosSePuedenIngresarAHabitats();*
En caso de que en el zoologico exista un hábitat, y un animal, podemos agregar el animal al habitat.

- *dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsPodemosObtenerUnAnimalDeUnHabitatParticular();* 
En caso de que el animal exista dentro del habitat se nos retornará el mismo.

- *dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiElHabitatNoEstaEnElZoologico();*
En caso de que el habitat no se encuentre dentro del zoológico, al intentar agregar un animal al mismo se lanzará una NoExisteObjetoDondeSeBuscaException.

- *dadoQueExisteUnZoologicoConAnimalesDentroDeHabitatsNoPodemosAgregarAnimalesSiNoEstanEnElZoologico();* 
Similar a la situación anterior, pero ahora verifica lo que sucede al intentar agregar animales que no se encuentran dentro del zoo. También se lanza una NoExisteObjetoDondeSeBuscaException.

- *dadoQueExisteUnZoologicoConHabitatsEstosNoDebenAlbergarDistintasEspecies();*
Cada hábitat puede albergar una sola especie, ya que al mezclarlas esto podría generar un desbalance en la naturaleza, puesto que podría depredarse u otras situaciones similares. Al ingresar al primer animal, se lo almacena y posteriormente se compara su clase con la de los nuevos animales a ingresar. Si la clase del nuevo no coincide con la del primer animal, este no se podrá agregar, y se lanzará una EspecieDiferenteException.

- *dadoQueExisteUnZoologicoConHabitatsNoSePuedenIngresarMasAnimalesSiEsteEstaLleno();* 
Cada hábitat tiene una capacidad limitada para albergar animales. En caso de que intentemos agregar un animal y resulte que el size de la colección de animales del habitat ya es igual al límite, no se agregará. Además, se lanzará una HabitatLlenoException.

- *dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnaMismaCategoria();*
Al ejecutar el método se pasará por parámetro una categoría (MAMIFERO, AVE, REPTIL, ANFIBIO, PEZ), y a través de un bucle foreach se agregarán a una lista auxiliar todos aquellos que posean igual categoría a la pasada.

- *dadoQueExisteUnZoologicoConAnimalesPodemosObtenerTodosLosDeUnMismoSexo();*
Al ejecutar el método se pasará por parámetro un tipo de sexo (FEMENINO, MASCULINO), y a través de un bucle foreach se agregarán a una lista auxiliar todos aquellos que posean igual sexo al pasado.

- *dadoQueExisteUnZoologicoConHabitatsSusAnimalesePuedenReproducir();* 
Si dos animales están en el mismo hábitat, esos pueden reproducirse. De esto resultaría una nueva instancia de su especie, a la cual solo le podemos asignar un número para identificarlo y un nombre. Atributos como peso y edad se inicializan con valores bajos, ya que es una cría, y el sexo se asigna mediante la clase Random. La categoría y tipo de alimentación se toma de uno de sus progenitores. La nueva instancia debe ser agregada al habitat donde viven sus padres y se reproducieron.

- *dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiSonDelMismoSexo();* 
Para que dos animales se puedan reproducir, tal y como en la vida real, deben ser de distinto sexo. Si son del mismo, no se ejecutará el método, y se lanzará una ProgenitoresDelMismoSexoException.class.

- *dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiElHabitatYaEstaLleno();*
Al igual que no podemos agregar animales cuando un habitat está lleno, dos animales no pueden reproducirse ya que no habrá espacio para albergar a la cría. En este caso, también se lanza una HabitatLlenoException.

- *dadoQueExisteUnZoologicoConHabitatsSusAnimalesNoSePuedenReproducirSiEstanEnDistintoHabitat();*
Los animales deben reproducirse en un habitat que se pasa oor parámetro, y es imprescindible que ambos existan en el mismo, tanto para verificar que sean de la misma especie (subclase) y que la cría se pueda ubicar junto con ellos. Si no están en el mismo, se lanza una ProgenitoresEnDistintoHabitatException.

- *dadoQueExisteUnZoologicoConVeterinariosQueEstanEnHospitalesPodemosObtenerUnVeterinarioDeUnHospital();* 
En caso de que el veterinario exista dentro del hospital se nos retornará el mismo.

- *dadoQueExisteUnZoologicoConUnHospitalQueSePuedaCrearUnRegistroDeTratamientoAlCurarUnVeterinarioAUnAnimal();*
Al ejecutar el método para que un veterinario cure un animal enfermo en un hospital veterinario, se retira al animal de su habitat, se lo trata (su atributo estaEnfermo pasa a ser false), y se crea un registro donde se almacena qué veterinario y qué animal participaron de la acción. Luego, se devuelve al animal a su habitat

- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiYaEstaSano();*
Antes de llevarse a cabo el método, se verifica que el estado del animal sea el correcto (estaEnfermo == true). De no ser así, no es posible curarlo, ya que no hay de qué. Se lanzará una EstadoDelObjetoEsIncorrectoException.

- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiLaPersonaQueAtiendeNoEsUnVeterinario();* 
Sabemos que para atender a un animal se necesitan estudios, por lo que la única instancia de Persona que puede atenderlo es el veterinario. Si se ingresa una instancia distinta, se ejecutará una InstanciaIncorrectaException.

- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElZoologico();* 
Si el veterinario no existe dentro del zoologico, no se lo podrá agregar al hospital, y no se ejecutará el método. Se lanzará una NoExisteObjetoDondeSeBuscaException.

- *dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaCurarUnAnimalSiElVeterinarioNoEstaEnElHospital();*
Si el veterinario no está en el hospital donde se llevará a cabo la atención, no se ejecutará el método, y se lanzará una NoExisteObjetoDondeSeBuscaException.

- *dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosAnimalesQueTratoUnVeterinarioParticular();*
Debido a que los tratamientos se almacenan dentro de registros, se pueden obtener a todos los animales que trató un veterinario. Se recorren los registros con un bucle foreach, y aquellas posiciones en las que el veterinario coincida con el del parámetro, se agregará el animal a una lista auxiliar, la cual se retornará.

- *dadoQueExisteUnZoologicoConUnHospitalSePuedenObtenerTodosLosVeterinariosQueAtendieronAUnAnimalParticular();* 
Similar al test anterior, se pueden obtener a todos los veterinarios que atendieron a un animal. Se recorren los registros con un bucle foreach, y aquellas posiciones en las que el animal coincida con el del parámetro, se agregará el veterinario a una lista auxiliar, la cual se retornará.



#### Uso de:
- [x] Herencia
- [x] Polimorfismo
- [x] Excepciones
- [x] Clases Abstractas
- [x] Uso de JUNIT 4
- [x] Uso de ordenamiento con comparator
- [x] Listas (set y list)
- [x] Interfaces


## Creadores
[Arias, Sol Macarena](https://github.com/SolAriass)

[Bon, Nicolás Agustín](https://github.com/nicolassbon)

[Gomez Wusinowski, Jimena Rocío](https://github.com/jimwux)

[Ramirez, Sergio Daniel](https://github.com/SergioDanRam)

[Recchia Molina, Javier Octavio](https://github.com/JaviRecchia)
