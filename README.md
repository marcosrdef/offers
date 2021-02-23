# offers
1 - caso já tenha o docker instalado e já tenha gerado as imagens e startado os containers do kafka, zookeeper e do dynamoDB no projeto de renegociação,
não necessita executar novamente, caso contrário seguir os passos abaixa
2 - caso não tenha o docker e o docker-compose instalado, será necessário instalar
3 - após a instalação executar os comandos docker-compose -f docker-compose.yml -p renegociation up para subir o container do dynamoDB,do zookeeper e do kafka
4 - clonar o projeto de renegociação e subir a aplicação local (quando subir ele, irá criar algumas tabelas e popular no dynamoDB)
5 - clonar o projeto de efetivação de renegociação e subir a aplicação local
6 - clonar o projeto de listagem de ofertas e subir a aplicação local
7 - o projeto é baseado em arquitetura de eventos, então executar primeiramente os serviços do projeto de renegociação, cada endpoint do controller
irá enviar para um tópico específico no kafka que será escutado por um listener no projeto de efetivação de renegociação (no caso de simulação e efetivação)
e um listener no projeto de listagem de produtos que irá de fato execucação de cada item, para consultar os valores de retorno, pegar o id da transação no momento
do envio da mensagem no kafka e utilizar no controller de cada projeto
8 - antes de executar o projeto é necessário subir a aplicação local do microserviço renegociation antes, além dos containers no docker precisarem estar de pé também
9 - esse microserviço serve como consumer, mas coloquei também um endpoint para acessar via controller, para consultar o que foi processado, da listagem
de ofertas do cliente

endpoint: http://localhost:8093/offers
Verbo: GET


body request:
{
    "groupOffersId": "701e8636-7cad-4569-9816-7228db6bdf96" (id do grupo de ofertas. Ele é gerado no response	
															do micro serviço renegociation, no endpoint products request)
}

exemplo de response:

{
    "offers": [
        {
            "id": "bf65b12c-233d-4ff9-983f-8d001033a089",
            "documentId": "12768334073",
            "offer": "financiamento auto",
            "description": "crédito pré aprovado de R$ 75.000,00 taxa 1,99% a.m",
            "date": "2021-02-17T16:52:25.003Z",
            "dateLimit": "Tue May 18 13:52:24 BRT 2021",
            "status": "1",
            "groupOffersId": "701e8636-7cad-4569-9816-7228db6bdf96"
        },
        {
            "id": "c6890d3b-a8f9-4d93-917c-d7de9e623d6b",
            "documentId": "12768334073",
            "offer": "consórcio",
            "description": "consórcio pré aprovado de R$ 100.000,00 taxa 0,59% a.a",
            "date": "2021-02-17T16:52:25.002Z",
            "dateLimit": "Tue May 18 13:52:24 BRT 2021",
            "status": "1",
            "groupOffersId": "701e8636-7cad-4569-9816-7228db6bdf96"
        },
        {
            "id": "a15f2793-2ae3-4e9e-866b-ec62addfd37a",
            "documentId": "12768334073",
            "offer": "cartão de crédito platinum",
            "description": "cartão de crédito platinum com R$ 15.000,00 de limite com isenção mensalidade por 3 meses",
            "date": "2021-02-17T16:52:25.003Z",
            "dateLimit": "Tue May 18 13:52:24 BRT 2021",
            "status": "1",
            "groupOffersId": "701e8636-7cad-4569-9816-7228db6bdf96"
        }
    ]
}
