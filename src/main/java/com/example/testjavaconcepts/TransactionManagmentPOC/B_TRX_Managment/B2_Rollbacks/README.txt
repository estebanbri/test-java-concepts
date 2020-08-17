Rollbacks:
- Unchecked Exceptions (Runtime Exceptions): automaticamente son siempre rollbackeadas por spring.
- Checked Exceptions (Non Runtime Exceptions): no son rollbackeadas automaticamente por spring,
    tenes que especificarle @Transactional(rollbackFor="{Nombre_Exception.class}")