import { useEffect, useState } from "react";
import { criarAluno, atualizarAluno, deletarAluno, getAlunoPorId, getAlunos } from "./api";
import '../src/app.css';

function App() {
  const [alunos, setAlunos] = useState([]);
  const [id, setIdBusca] = useState("");
  const [loading, setLoading] = useState(false);
  const [erro, setErro] = useState(null);
  const [modoBusca, setModoBusca] = useState(false);
  const [editando, setEditando] = useState(false);
  const [form, setForm] = useState({id: "", nome:"", curso:"", sexo:"" });

  useEffect(() => {
    carregar();
  }, []);

  const buscarPorID = async () =>{
    try{
      const data = await getAlunoPorId(id);
      setAlunos([data]);
      setModoBusca(true);
    }catch (err){
      alert("Aluno não encontrado");
    }
  };

  const carregar = async () => {
    setErro(null);
    setLoading(true);
    try {
      const data = await getAlunos();
      setAlunos(data || []);
      setModoBusca(false);
    } catch (e) {
      setErro("Erro ao carregar lista");
      setAlunos([]);
    } finally {
      setLoading(false);
    }
  };

  const alterar = async (aluno) =>{
      setForm(aluno);
      setEditando(true);
  
};
  
  
  const excluir = async (id) => {
    try {
      await deletarAluno(id);
      setAlunos(prev => prev.filter(a => a.id !== id));
    } catch {
      setErro("Erro ao excluir aluno");
    }
  };

  const salvar = async (e) =>{
    e.preventDefault();
    if(!form.nome.trim() || !form.curso.trim() || !form.sexo.trim()) return;
    try{
      if(editando){
        await atualizarAluno(form.id, form);
        setAlunos(prev=> prev.map(a=> a.id ===form.id ? form:a));
        setEditando(false);
      }
      else{
        const data = await criarAluno(form);
        setAlunos(prev =>[...prev, data]);
      }
      setForm({id:"", nome:"", curso:"", sexo:""})
    } catch{
      setErro(editando ? "Erro ao atualizar aluno ": "Erro ao adicionar aluno");
    } 
  };

  return (
    <main>
      <h1>Cadastro de Falecidos</h1>

      <form onSubmit={salvar}>
        <input
          type="text"
          value={form.nome}
          onChange={e => setForm({ ...form, nome: e.target.value })}
          placeholder="Nome"
        />
        <input
          type="text"
          value={form.curso}
          onChange={e => setForm({ ...form, curso: e.target.value })}
          placeholder="Curso"
        />
        <input
          type="text"
          value={form.sexo}
          onChange={e => setForm({ ...form, sexo: e.target.value })}
          placeholder="Sexo"
        />

        <button type="submit">{editando ? "Atualizar" : "Adicionar"}</button>
        {editando && (
          <button
            type="button"
            onClick={() => {
              setEditando(false);
              setForm({ id: "", nome: "", curso: "", sexo: "" });
            }}
          >
            Cancelar
          </button>
        )}
      </form>

      <div>
        <input type="number" value={id} onChange={e => setIdBusca(e.target.value)}placeholder="Buscar por ID"/>
        <button onClick={buscarPorID} type="button">Buscar</button>
        <button onClick={carregar} type="button">Limpar Busca</button>
      </div>

      {loading && <p>Carregando...</p>}
      {erro && <p className="erro">{erro}</p>}

      <ul>
        {Array.isArray(alunos) && alunos.map((a, i) => (
          <li key={a?.id ?? i}>
            <span>
              #{a?.id ?? "?"} - {a?.nome ?? ""} | {a?.curso ?? ""} | {a?.sexo ?? ""}
            </span>
            {a?.id && <button onClick={() => excluir(a.id)}>Excluir</button>}
            {a?.id && <button onClick={() => alterar(a)}>Alterar</button>}
          </li>
        ))}
      </ul>
    </main>
  );
}

export default App;