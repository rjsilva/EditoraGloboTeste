# language: pt

Funcionalidade: Visualizar Fotos na Fotogalerias



Cenário: visualizar fotos recomendadas
Dado que eu estiver na fotogalerias
Quando eu ir ate a secao recomendadas
Entao devo visualizar 6 fotos na secao "recomendadas"
	

Cenário: visualizar fotos mais vistas
Dado que eu estiver na fotogalerias
Quando eu ir ate a secao mais vistas
Entao devo visualizar 3 fotos na secao "mais vistas"

@Test
Esquema do Cenario: visualizar fotos ultimas de
Dado que eu estiver na fotogalerias
Quando eu ir ate a secao ultimas de
E selecionar uma <opcao>
Entao devo visualizar <quantidade> fotos por titulo

Exemplos:
|     opcao        | quantidade |
|     "Todas"      |    3       |
|     "Rio"        |    3       |
|     "Brasil"     |    3       |
|     "Mundo"      |    3       |
|     "Economia"   |    3       |
|     "Sociedade"  |    3       |
|     "Tecnologia" |    3       |
|     "Ciência"    |    3       |
|     "Saúde"      |    3       |
|     "Cultura"    |    3       |
|     "Ela"        |    3       |
|     "Esportes"   |    3       |
|     "TV"         |    3       |
|     "Boa Viagem" |    3       |



	

	
