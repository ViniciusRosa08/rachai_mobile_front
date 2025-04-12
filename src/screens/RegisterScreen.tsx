import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, Alert, StyleSheet } from 'react-native';
import { useNavigation } from '@react-navigation/native';

export default function RegisterScreen() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const navigation = useNavigation();

    const validarEmail = (email: string) => email.endsWith('@aluno.ifsp.edu.br');
    const validarSenha = (senha: string) => /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*]).{8,}$/.test(senha);

    const handleCadastro = () => {
        if (!nome || !email || !senha) {
            Alert.alert('Erro', 'Preencha todos os campos.');
            return;
        }

        if (!validarEmail(email)) {
            Alert.alert('Erro', 'O e-mail deve ser institucional (@aluno.ifsp.edu.br)');
            return;
        }

        if (!validarSenha(senha)) {
            Alert.alert('Erro', 'A senha deve ter no mínimo 8 caracteres, uma letra maiúscula, um número e um caractere especial.');
            return;
        }

        // Simula cadastro
        Alert.alert('Sucesso', 'Cadastro realizado com sucesso!');
        navigation.navigate('Login');
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Cadastro</Text>

            <TextInput
                placeholder="Nome"
                value={nome}
                onChangeText={setNome}
                style={styles.input}
            />

            <TextInput
                placeholder="E-mail"
                value={email}
                onChangeText={setEmail}
                style={styles.input}
                keyboardType="email-address"
            />

            <TextInput
                placeholder="Senha"
                value={senha}
                onChangeText={setSenha}
                style={styles.input}
                secureTextEntry
            />

            <TouchableOpacity style={styles.button} onPress={handleCadastro}>
                <Text style={styles.buttonText}>Cadastrar</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: { padding: 20, flex: 1, justifyContent: 'center' },
    title: { fontSize: 24, fontWeight: 'bold', marginBottom: 20, alignSelf: 'center' },
    input: { borderWidth: 1, padding: 12, borderRadius: 8, marginBottom: 10 },
    button: { backgroundColor: '#007AFF', padding: 12, borderRadius: 8 },
    buttonText: { color: '#fff', textAlign: 'center', fontWeight: 'bold' }
});
