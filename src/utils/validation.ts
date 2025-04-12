export const isEmailValido = (email: string): boolean => {
    return email.endsWith('@aluno.ifsp.edu.br') || email.endsWith('@ifsp.edu.br');
  };
  
  export const isSenhaValida = (senha: string): boolean => {
    const regex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return regex.test(senha);
  };
  