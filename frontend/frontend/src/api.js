import axios from "axios";


const api = axios.create({

    baseURL: "http://localhost:8080"
});


export const getAlunos = async()=>{
    const response = await api.get("/alunos");
    return response.data;
};

export const getAlunoPorId = async (id) => {
  const response = await api.get(`/alunos/${id}`);
  return response.data;
};

export const criarAluno = async (aluno) => {
  const response = await api.post("/alunos", aluno);
  return response.data;
};

export const atualizarAluno = async (id, aluno) => {
  const response = await api.put(`/alunos/${id}`, aluno);
  return response.data;
};

export const deletarAluno = async (id) => {
  await api.delete(`/alunos/${id}`);
};




/*export feito em unico objeto nao é recomendado pois faz o bundling por completo, tornando o processo mais pesado*/
/*export const AlunosAPI = {
    listar:async ()=>{
        const {data} = await api.get("/alunos");
        return data;
    },
    criar:async (nome)=> {
        const {data } = await api.post ("/alunos", {id:0, nome });
        return data;
    },
    excluir:async(id)=>{
        await api.delete(`/alunos/${id}`);
    },*/





