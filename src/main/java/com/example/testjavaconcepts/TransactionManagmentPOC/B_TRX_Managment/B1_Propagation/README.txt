Propagacion de transacciones:
Nota: Llamaremos '@Tm#', a metodo anotado con @Trasactional(propagation = {PROPAGATION_VALUE})

    -  REQUIRED (Es el valor implicito por defecto)
        -- Called Directamente: @Tm1 crea una nueva trx.
        -- Called Indirectamente: trata de reutilizar la trx del metodo @Tm2 que le hace el call, en caso de que el caller no tenga trx, @Tm1 crea su propia new trx.

    -  SUPPORTS (Trata de reutilizar trx)
        -- Called Directamente: @Tm1 no crea una nueva trx.
        -- Called Indirectamente: trata de reutilizar la trx del metodo @Tm2 que le hace el call, en caso de que el caller no tenga trx, @Tm1 no crea su propia new trx.

    -  NOT_SUPPORTED (No se ejecuta nunca dentro de una trx)
        -- Called Directamente: @Tm1 no crea una nueva trx.
        -- Called Indirectamente:  Aunque el metodo @Tm2 que le hace el call venga con una trx, igualmente @Tm1 va a ejecutarse fuera de trx.  En caso de que caller no venga con una trx, @Tm1 no va crear una nueva trx.

    -  REQUIRES_NEW (Siempre crea una trx nueva)
        -- Called Directamente: @Tm1 crea una nueva trx.
        -- Called Indirectamente: Aunque el metodo @Tm2 que le hace el call venga con una trx, @Tm1 igualmente va a crear su propia new trx.

    -  NEVER (No se ejecuta nunca dentro de una trx, pero lanza excepcion en caso de ser llamado con trx)
        -- Called Directamente: @Tm1 no crea una nueva trx.
        -- Called Indirectamente:  Si metodo @Tm2 que le hace el call venga con una trx,  @Tm1 lamzara una excepcion.  En caso de que caller no venga con una trx, @Tm1 no va crear una nueva trx.

    -  MANDATORY (En caso de llamarlo directamente lanzara una excepcion, unicamente admite ser llamados por @Tm# que le provean trx)
        -- Called Directamente: @Tm1 va a lanzar una excepcion.
        -- Called Indirectamente: trata de reutilizar la trx del metodo @Tm2 que le hace el call. En caso de que el caller no tenga trx @Tm1 lanzara una excepcion.

