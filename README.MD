## Classe DataNest: </br>
[X] setHeader(List<Object> header): Define o cabeçalho do DataNest.</br>
[X] addRow(List<Object> row): Adiciona uma linha de dados ao DataNest.</br>
[X] get(): Retorna todos os dados do DataNest.</br>
[X] getColumn(int index): Retorna a coluna pelo índice.</br>
[X] getColumn(String name): Retorna a coluna pelo nome.</br>
[X] filter(String column, Object value): Filtra linhas com base em valor da coluna.</br>
[X] getRow(int index): Retorna uma linha específica pelo índice.</br>
[X] removeRow(int index): Remove uma linha específica pelo índice.</br>
[X] count(): Retorna o número de linhas.</br>
[X] countColumns(): Retorna o número de colunas.</br>
[X] addColumn(String columnName, Object data): Adiciona uma coluna com um valor padrão.</br>
[X] addColumn(String columnName, List<Object> columnData): Adiciona uma coluna com uma lista de dados.</br>
[X] print(): Imprime os dados do DataNest.</br>
[X] sort(String columnName, boolean ascending): Ordena as linhas com base em uma coluna.</br>
[ ] groupBy(String columnName): Agrupa as linhas com base em uma coluna.</br>
[ ] merge(DataNest other, String onColumn): Mescla dois DataNests com base em uma coluna.</br>
[ ] dropColumn(String columnName): Remove uma coluna específica.</br>
[ ] dropna(): Remove linhas com valores nulos.</br>
[ ] fillna(Object value): Preenche valores nulos com um valor específico.</br>
[ ] apply(Function<List<Object>, List<Object>> function): Aplica uma função a cada linha.</br>
[ ] head(int n): Retorna as primeiras n linhas.</br>
[ ] tail(int n): Retorna as últimas n linhas.</br>
[ ] describe(): Retorna estatísticas descritivas para cada coluna numérica.</br>
[ ] transpose(): Transpõe o DataNest.</br>
[ ] toCSV(String filePath): Exporta o DataNest para um arquivo CSV.</br>
[ ] fromCSV(String filePath): Carrega um DataNest de um arquivo CSV.</br>

## Classe Column: </br>
[X] setColumn(List<Object> column): Define a lista de dados da coluna.</br>
[X] setColumn(List<Object> column, String name): Define a coluna e seu nome.</br>
[X] print(): Imprime os dados da coluna.</br>
[X] count(): Retorna o número de elementos na coluna.</br>
[X] countIf(Object value): Conta elementos iguais ao valor.</br>
[X] countIfNot(Object value): Conta elementos diferentes do valor.</br>
[X] filter(Object value): Filtra elementos iguais ao valor.</br>
[ ] unique(): Retorna valores únicos na coluna.</br>
[ ]valueCounts(): Retorna a contagem de valores únicos.</br>
[ ]apply(Function<Object, Object> function): Aplica uma função a cada elemento da coluna.</br>
[ ]mean(): Calcula a média dos valores numéricos.</br>
[ ]sum(): Calcula a soma dos valores numéricos.</br>
[ ]min(): Retorna o valor mínimo.</br>
[ ]max(): Retorna o valor máximo.</br>
[ ]std(): Calcula o desvio padrão dos valores numéricos.</br>
[ ]median(): Calcula a mediana dos valores numéricos.</br>
[ ]mode(): Retorna o(s) valor(es) mais frequente(s).</br>