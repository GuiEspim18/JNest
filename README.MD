## Classe DataNest:
[X] setHeader(List<Object> header): Define o cabeçalho do DataNest.
[X] addRow(List<Object> row): Adiciona uma linha de dados ao DataNest.
[X] get(): Retorna todos os dados do DataNest.
[X] getColumn(int index): Retorna a coluna pelo índice.
[X] getColumn(String name): Retorna a coluna pelo nome.
[X] filter(String column, Object value): Filtra linhas com base em valor da coluna.
[X] getRow(int index): Retorna uma linha específica pelo índice.
[X] removeRow(int index): Remove uma linha específica pelo índice.
[X] count(): Retorna o número de linhas.
[X] countColumns(): Retorna o número de colunas.
[X] addColumn(String columnName, Object data): Adiciona uma coluna com um valor padrão.
[X] addColumn(String columnName, List<Object> columnData): Adiciona uma coluna com uma lista de dados.
[X] print(): Imprime os dados do DataNest.
[ ] sort(String columnName, boolean ascending): Ordena as linhas com base em uma coluna.
[ ] groupBy(String columnName): Agrupa as linhas com base em uma coluna.
[ ] merge(DataNest other, String onColumn): Mescla dois DataNests com base em uma coluna.
[ ] dropColumn(String columnName): Remove uma coluna específica.
[ ] dropna(): Remove linhas com valores nulos.
[ ] fillna(Object value): Preenche valores nulos com um valor específico.
[ ] apply(Function<List<Object>, List<Object>> function): Aplica uma função a cada linha.
[ ] head(int n): Retorna as primeiras n linhas.
[ ] tail(int n): Retorna as últimas n linhas.
[ ] describe(): Retorna estatísticas descritivas para cada coluna numérica.
[ ] transpose(): Transpõe o DataNest.
[ ] toCSV(String filePath): Exporta o DataNest para um arquivo CSV.
[ ] fromCSV(String filePath): Carrega um DataNest de um arquivo CSV.

## Classe Column:
[X] setColumn(List<Object> column): Define a lista de dados da coluna.
[X] setColumn(List<Object> column, String name): Define a coluna e seu nome.
[X] print(): Imprime os dados da coluna.
[X] count(): Retorna o número de elementos na coluna.
[X] countIf(Object value): Conta elementos iguais ao valor.
[X] countIfNot(Object value): Conta elementos diferentes do valor.
[X] filter(Object value): Filtra elementos iguais ao valor.
[ ] unique(): Retorna valores únicos na coluna.
[ ]valueCounts(): Retorna a contagem de valores únicos.
[ ]apply(Function<Object, Object> function): Aplica uma função a cada elemento da coluna.
[ ]mean(): Calcula a média dos valores numéricos.
[ ]sum(): Calcula a soma dos valores numéricos.
[ ]min(): Retorna o valor mínimo.
[ ]max(): Retorna o valor máximo.
[ ]std(): Calcula o desvio padrão dos valores numéricos.
[ ]median(): Calcula a mediana dos valores numéricos.
[ ]mode(): Retorna o(s) valor(es) mais frequente(s).