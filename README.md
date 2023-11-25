# Global Solution 2 (2023)
- Digital Business Enablement<br>
- DevOps and Cloud Computing

## API FollowCare
Solução desenvolvida para servir como API da FollowCare. A imagem a seguir
vai ilustrar  

## Arquitetura da Solução
<img src="gs2_api_trekker.png">

## Deploy
### Pre-requisitos
- Ter criado os recursos: Web App e SQL Azure (PaaS)
- Criar as variáveis de ambiente para `BANCO_NOME`, `BANCO_SENHA`, `BANCO_URL`, `BANCO_USUARIO`, `NOME_SQL_SERVER`, `SECRET_JWT` (Spring Security) no `Painel do Web App` > `Configurações` > `New Application Setting`
- Ou através do `App settings` disponível no momento da configuração do deploy do `Azure App Service deploy`

### Passo a Passo
- Para executar o deploy basta linkar o repositório no processo de configuração do `CI` e habilitar o a opção de `Enable continuous integration ` na aba `Triggers`. <br>
- Certifique-se que as credenciais foram adicionadas nas variáveis de ambiente <br>
- Uma vez feito esses passos basta realizar um `commit` para que o CI seja acionado e as etapas deste sendo executadas com sucesso o processo de deploy será feito
de forma automatica

- Link Deploy: [API no Azure](https://webapp-followcare.azurewebsites.net/)

### JSON utilizado em vídeo
- Registro: `/auth/register` - Exemplo:
- `Role`: ADMIN ou PACIENTE
```
{
    "nm_paciente": "Felipe",
    "dt_nascimento": "1997-05-06",
    "cpf": "91135609221",
    "senha": "dgVRDJq9",
    "role": "ADMIN"
}
```
- Login: `/auth/login` - Exemplo:
```
{
    "login": "91135609221",
    "password": "dgVRDJq9"
}
```

PUT e DELETE:
- Paciente: `/paciente/<id>` - Exemplo:
```
{
    "nm_paciente": "Vinicius",
    "dt_nascimento": "1997-06-05",
    "cpf": "91135609221",
    "senha": "ieZiw9eevie",
    "role": "ADMIN"
}
```
- Medico: `/medico` - Exemplo:
```
{
    "nm_medico": "Douglas",
    "nm_crm": "1734058",
    "ds_especialidade": "Cirurgiao"
}
```
- Consulta: `/consulta` - Exemplo:
```
{
    "cd_medico": {
        "cd_medico": 1
    },
    "cd_paciente": {
        "cd_paciente": 2
    },
    "dt_consulta": "2023-05-05",
    "hr_consulta": "12:00:00"
}
```
- Medicamento: `/medicamento` - Exemplo:
```
{
    "cd_paciente": {
        "cd_paciente": 6
    },
    "nm_medicamento": "Amoxicilina",
    "ds_dosagem": "125mg",
    "ds_frequencia": "8"
}
```
- Efeito Colateral: `/efeitocolateral` - Exemplo:
```
{
    "cd_medicamento": {
        "cd_medicamento": 1
    },
    "ds_efeito_colateral": "Dor de cabeca"
}
```
- `Paginação`: `/efeitocolateral/paginacao` - Exemplo:
```
{
    "page": 0,
    "size": 5
}
```


### Video para `DevOps and Cloud Computing`
[Video DevOps](https://youtu.be/JjBcxc9s_Q4)

### Video para `Digital Business Enablement`
[Video Digital](https://youtu.be/uQPGyybLT6g)

### Pitch
[Video Pitch](https://youtu.be/Qbllia3FjQY)

