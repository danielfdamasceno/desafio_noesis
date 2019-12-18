#language: pt
@tag
Funcionalidade: Acessar pesquisa de medico detalhada
  como um usuario do sistema
  eu quero realizar a pesquisa de medico
  de modo que eu possa detalhar esta pesquisa

  @tag1
  Cenario: Pesquisar medicos do estado do Rio de Janeiro
    Dado acessar a pagina da Unimed
    E clicar no icone de guia medico
    E informar o nome do medico "Daniel"
    E acionar pesquisar
    E escolher estado "Rio de Janeiro"
    E escolher a cidade "Rio de Janeiro"
    E selecionar a unidade
    Quando clicar em continuar
    Então sistema exibe a lista de medicos

  @tag2
  Cenário: Validar pesquisa de medicos do estado de Sao Paulo
    Dado acessar a pagina da Unimed
    E clicar no icone de guia medico
    E informar o nome do medico "Daniel"
    E acionar pesquisar
    E escolher estado "Rio de Janeiro"
    E escolher a cidade "Rio de Janeiro"
    E selecionar a unidade
    Quando clicar em continuar
    Então sistema exibe a lista de medicos
    E nao pode exibir o estado Sao Paulo

  @tag3
  Cenário: Validar paginacao
    Dado acessar a pagina da Unimed
    E clicar no icone de guia medico
    E informar o nome do medico "Daniel"
    E acionar pesquisar
    E escolher estado "Rio de Janeiro"
    E escolher a cidade "Rio de Janeiro"
    E selecionar a unidade
    Quando clicar em continuar
    Então sistema exibe a lista com mais de tres
