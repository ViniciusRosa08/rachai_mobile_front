import React from 'react';
import { View, Text, FlatList, TouchableOpacity, StyleSheet } from 'react-native';
import { Viagem } from '../../models/Viagem';

const mockViagens: Viagem[] = [
    { origem: 'São Paulo', destino: 'Campinas', data: '12/04/2025' },
    { origem: 'Sorocaba', destino: 'Jundiaí', data: '15/04/2025' },
];

export default function ListaViagensScreen({ navigation }) {
    return (
        <View style={styles.container}>
            <FlatList
                data={mockViagens}
                keyExtractor={(_, index) => index.toString()}
                renderItem={({ item }) => (
                    <TouchableOpacity onPress={() => navigation.navigate('DetalhesViagem', { viagem: item })}>
                        <Text style={styles.item}>{item.origem} ➡ {item.destino} - {item.data}</Text>
                    </TouchableOpacity>
                )}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: { flex: 1, padding: 16 },
    item: { fontSize: 18, padding: 12, borderBottomWidth: 1 }
});
