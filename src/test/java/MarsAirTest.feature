@MarsAir
Feature: MarsAir

  @VisualizacaoNomes
  Scenario Outline: Validação dos nomes dos campos na tela inicial
    Given que acesso o link "https://marsair.thoughtworks-labs.net/alcemirlapola"
    Then valido o titulo "<titulo>"
    And valido o subtitulo "<subtitulo>"
    And valido os campos "<campo1>" e "<campo2>" e "<campo3>"

    Examples: 
      | titulo              | subtitulo                            | campo1    | campo2    | campo3           |
      | Welcome to MarsAir! | Book a ticket to the red planet now! | Departing | Returning | Promotional Code |

  @RealizarPesquisaCenarioSucesso
  Scenario Outline: Realizar pesquisa com data de ida maior que um ano da data da volta (com assento disponível)
    Given que acesso o link "https://marsair.thoughtworks-labs.net/alcemirlapola"
    When seleciono a data de ida menor que um ano da data de volta
    And clico no botao "Search"
    Then a seguinte mensagem deve ser exibida "<mensagem1>", "<mensagem2>"

    Examples: 
      | mensagem1        | mensagem2                         |
      | Seats available! | Call now on 0800 MARSAIR to book! |

  @RealizarPesquisaCenarioErro
  Scenario Outline: Realizar pesquisa com data de ida menor que um ano da data de volta
    Given que acesso o link "https://marsair.thoughtworks-labs.net/alcemirlapola"
    When seleciono a data de ida maior que um ano da data de volta
    And clico no botao "Search"
    Then a seguinte mensagem deve ser exibida "<mensagem>"

    Examples: 
      | mensagem                                                        |
      | Unfortunately, this schedule is not possible. Please try again. |

  @RealizarPesquisaValidandoCodigoPromocional
  Scenario Outline: Código Promocional (validar desconto)
    Given que acesso o link "https://marsair.thoughtworks-labs.net/alcemirlapola"
    When seleciono a data de ida menor que um ano da data de volta
    And preencho um codigo promocional com valor "AF3-FJK-418"
    And clico no botao "Search"
    Then valido a mensagem de desconto "<mensagem1>", "<mensagem2>"

    Examples: 
      | mensagem1   | mensagem2    |
      | AF3-FJK-418 | 30% discount |

  @RealizarPesquisaValidandoCodigoPromocionalInvalido
  Scenario Outline: Código Promocional inválido
    Given que acesso o link "https://marsair.thoughtworks-labs.net/alcemirlapola"
    When seleciono a data de ida menor que um ano da data de volta
    And preencho um codigo promocional com valor "XXX-FJK-418"
    And clico no botao "Search"
    Then valido a mensagem de desconto "<mensagem1>", "<mensagem2>"
    
        Examples: 
      | mensagem1    | mensagem2     |
      | XXX-FJK-418  |  is not vali  |

