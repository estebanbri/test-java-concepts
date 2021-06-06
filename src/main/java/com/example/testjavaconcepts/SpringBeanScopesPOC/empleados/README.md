# spring-bean-scopes
Spring Bean Scopes poc

--------
- Requerimiento: 
Crear un dropdown que tenga la información de los empleados de un manager.

--------

Cuando tenemos que consumir datos de un endpoint / active directory que son time consuming, es preferible tener la información en
objectos en memoria (usando estos conocimientos de los distintos bean scopes) que pegarle cada vez al endpoint ya que es más costoso.

--------

# Pasos para reproducir escenario y ver las diferencias entre los distintos scopes de los beans de spring:

**Objetivo:** ver lo siguientes empleados para los siguientes managers:
- jose tiene como empleados a [Josualdo, Jacinto]
- pepe tiene como empleados a  [Patricio, Pancracio]


## En navegador CHROME ir a localhost:8080/manager/pepe/empleados

![singleton-scope](http://url/to/img.png)

## En navegador FIREFOX ir a localhost:8080/manager/jose/empleados

![request-scope](http://url/to/img.png)

## En navegador CHROME ir a localhost:8080/manager/pepe/empleados

![session-scope](http://url/to/img.png)
--------

### Resumen de los Scopes de los beans:

**SINGLETON SCOPE:**
> Es el scope por defecto de los bean de spring. Es decir se crea un unico bean dentro del contexto de spring por ende para este requerimiento no es de
> utilidad ya que no queremos que se comparta el estado de los empleados entre las N llamadas. Como vemos nos retorna siempre el mismo resultado.

**REQUEST SCOPE (@RequestScope):**
> Este scope hace que por cada uno de los request HTTP que reciba nuestro endpoint va a crear un nuevo bean dentro del contexto de spring.
> En nuestro ejemplo, solucionaria nuestro requerimiento pero como vemos en el output no es performante porque no queremos que para un mismo usuario 
> nos haga nuevamente una consulta al endpoint/active directory cada vez que se le pegue al endpoint de nuestra app.

**SESSION SCOPE (@SessionScope):**
> Este scope hace que por cada SESSION HTTP que exista en nuestra app se cree un nuevo bean dentro del contexto de spring y sea asociado a dicha SESSION HTTP.
> Por ende esta es la mejor alternativa para solucionar nuestro requerimiento porque unicamente se crearon como vemos en el output 2 llamadas al
> endpoint/active directory y los siguientes request que ambos usuarios hagan al endpoint de mi app va a retornar la informacion ya almacenada en los 
> bean que existen dentro del contexto de spring sin tener que volver a pegarle al endpoint/active directory.
