var app = new Vue({
  el: '#app',

  data: {
    mensagem: {},
    headers: [
      { text: 'Placa', sortable: true, value: 'placa' },
      { text: 'Proprietario', sortable: true, value: 'nomeProprietario' },
      { text: 'Data Emplacamento', sortable: true, value: 'dataEmplacamento' },
      { text: 'Valor IPVA', sortable: true, value: 'valorIpva' },
    ],
    veiculos: [],
  },

  mounted() {
    this.carregar();
  },
  
  methods: {
    carregar() {
      this.limparMensagem();
      veiculosService.selecionarTodos()
        .then(veiculos => {
          this.veiculos = veiculos;
        })
        .catch(error => {
          this.veiculos = [];
          this.exibirMensagem('error', 'Erro inesperado.');
        });
    },
    
    editar(id) {
      window.location = 'veiculos-editar.html?id=' + id;
    },

    exibirMensagem(tipo, texto) {
      this.mensagem = { tipo, texto, exibir: true };
    },

    limparMensagem() {
      this.mensagem = { tipo: 'info', texto: '', exibir: false };
    },
  }
});