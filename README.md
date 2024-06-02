Mis test realizados fueron los siguientes:

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerSiElPesoDelAnimalAumentoAlSerAlimentadoConSuComidaCorrespondiente();
En este test analizamos los registros de alimentación ingresados, los cuales solamente se crean si se alimento de una forma "correcta" al animal, ya que podria ser que el veterinario se confunda y al ser animales en cautiverio, comen de igual forma esa comida (CARNE O PLANTA). Una vez alimentado debemos consultar su peso para averiguar si realmente comio lo que debia y si engordo por esa comida.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosRegistrosQueContenganUnAnimalEspecifico();
En este test volveremos a analizar dichos registros y buscaremos en cada uno de ellos si se encuentra el animal que esperamos que este alli adentro, en caso de que este lo agregamos a una lista para luego ser analizada si fue agregado de forma correcta.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConCarne();
- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerALosAnimalesQueFueronAlimentadosConPlantas();
En estos test volveremos a analizar los registros para consultar si la comida que le dio el veterinario fue carne o plantas, en el caso de que sea asi, cada lista guarda su respectivo animal para ser analizado.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosVeterinariosQueAlimentaronAUnAnimalEspecifico();
En este test deberiamos obtener aquellos veterinarios que alimentaron por ejemplo a un Mono, consultaremos en cada registro si ese registro contiene a este animal para poder guardar luego la persona de ese registro (fue ingresado como persona para poder trabajar con instanceof de una manera más comoda, lo que me parecio más correcto) y enseñarla en el test correspondiente.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionConocerLosAnimalesQueAlimentoUnVeterinarioEspecifico();
Realiza la misma acción que el anterior solo que aca buscamos aquellos animales que fueron alimentados por un veterinario especifico.

- dadoQueExisteUnZoologicoConAnimalesConocerALosQueSeEnfermaronPorHaberSidoAlimentadosConComidaNoApta();
Aca profundizo en saber su estado de enfermedad, comprobandolo ya que los registros aunque esten "mal" (que el veterinario confunda el alimento) deben ser registrados para conocer que fue alimentado con algo que no debe, por ese motivo esta enfermo. Ya que si el animal se enferma por algo externo no deberia ser aceptado en este test.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearElRegistroSiUnPersonalNoAutorizadoQuiereAlimentarAlAnimal();
El test busca usar el instanceof, ya que al recibir el registro una persona nosotros tenemos que VERIFICAR que sea un veterinario, en caso de no serlo tendremos una excepcion ya realizada en el mismo test.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElAnimalEsInexistente();
- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueNoSePuedaCrearUnRegistroSiElVeterinarioEsInexistente();
En los test buscamos que no sea nulo el animal/veterinario o que no se haya agregado, de estos test tambien esperamos una excepcion ya colocada.

- dadoQueExisteUnZoologicoConRegistrosDeAlimentacionQueSeCreeUnRegistroCuandoUnVeterinarioAlimenteDeFormaCorrectaAlAnimal();
En este test creamos de forma correcta el registro, ingresando todos los datos de forma correcta y teniendo todas las validaciones correctas.

- dadoQueExisteUnZoologicoQueAlHacerseDeDiaSeDespiertenLosAnimales();
- dadoQueExisteUnZoologicoQueAlHacerseDeNocheLosAnimalesSeDuerman();
En estos test dependiendo la hora que sea el zoologico la cual es seteada podemos conocer si los animales se durmieron o estan despiertos, por ejemplo si el horario fuera 09:00 estarian despiertos, caso de que sean las 22:00 estan dormidos ya que seria el horario que estaria inactivo el zoo.

- dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarUnVeterinarioInexistente();
- dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarAUnHospitalInexistente();
En estos test corroboramos que exista ese veterinario/hospital, pero esto claramente nos daria una excepcion ya que no podriamos meter a un veterinario que no se encuentre en el zoo ni tratar de meter a un veterinario en una estructura que no existe.

- dadoQueExisteUnZoologicoConVeterinarioQueNoSePuedaAgregarEnOtraEstructuraQueNoSeaUnHospital();
- dadoQueExisteUnZoologicoConUnHospitalQueNoSePuedaAgregarOtroPersonalQueNoSeaVeterinario();
Debemos corroborar que el hospital sea donde entra el veterinario, ya que seria un error si queremos meterlo en el habitat de los animales por ejemplo. A su vez seria incorrecto meter a uno de mantenimiento o un visitante en el hospital ya que no sabrian como curar o manejarse dentro de el.

- dadoQueExisteUnZoologicoConVeterinarioQueSePuedaAgregarAUnHospital();
En este test se agregara de forma correcta ese veterinario ya que soportaria todas las validaciones para poder ingresar.

- dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesEnfermosDeSaludPorBajaTemperaturaCorporal();
-  dadoQueExisteUnZoologicoConAnimalesConocerALosAnimalesConTemperaturaCorporalNeutral();
En estos test debemos trabajar con la temperatura de los animales, por defecto ya tienen una temperatura la cual estarian bien con ella, pero si se pasa de ella (al setearlo) pasara a estar enfermo por ello.


- dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionHerbivora();
- dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionCarnivora();
- dadoQueExisteUnZoologicoConocerALosAnimalesConTipoDeAlimentacionOmnivora();
En estos tres test simplemente buscaremos en la lista del zoo aquel tipo de alimentacion que tengan para poder meterlo en la lista y mostrarlo en un test.


- dadoQueExisteUnZoologicoQueNoSePuedanAgregarEstructurasAlMismoSiEstaNoExiste();
- dadoQueExisteUnZoologicoQueNoSePuedanAgregarPersonasAlMismoSiEstaNoExiste();
- dadoQueExisteUnZoologicoQueNoSePuedanAgregarAnimalInexistente();
Simplemente tendremos que esperar excepciones ya que por algun motivo no pueden ser agregados (por ser inexistentes-> nulos).





