/* eslint-disable no-shadow */
/* eslint-disable react-native/no-inline-styles */
import React, {useState} from 'react';
import {SafeAreaView, View, Text} from 'react-native';
import LiveDetect from './LiveDetect';
import LiveDetectTip from './LiveDetectTip';
import Modal from 'react-native-modal';

const App = () => {
  const [actions, setActions] = useState<number[]>([]);
  const [warnMessage, setWarnMessage] = useState<string>();
  const [tipMessage, setTipMessage] = useState('');
  const [currentStep, setCurrentStep] = useState(0);
  const [visible, setVisible] = useState(false);
  const [resultMessage, setResultMessage] = useState<string>();
  const [token, setToken] = useState<string>();

  const handleActionChange = (e: {nativeEvent: {actions: string}}) => {
    const {actions = ''} = e.nativeEvent; // 0——正面，1——右转，2——左转，3——张嘴，4——眨眼

    if (actions.length > 0) {
      setActions(actions.split('').map((item) => +item));
    }
  };

  const handleWarnChange = (e: {
    nativeEvent: {
      message?: string;
    };
  }) => {
    const {message} = e.nativeEvent;
    setWarnMessage(message);
  };

  const handleStepChange = (e: {
    nativeEvent: {message?: string; currentStep?: number};
  }) => {
    setWarnMessage('');
    const {message, currentStep} = e.nativeEvent;
    if (message) {
      setTipMessage(message);
    }
    if (currentStep) {
      setCurrentStep(currentStep);
    }
  };

  const handleResultChange = (e: {
    nativeEvent: {message?: string; token?: string};
  }) => {
    const {message, token} = e.nativeEvent;
    setWarnMessage('');
    setVisible(true);
    setResultMessage(message);
    setToken(token);
  };

  return (
    <SafeAreaView style={{flex: 1}}>
      <View
        style={{
          flex: 1,
          justifyContent: 'center',
          alignItems: 'center',
        }}>
        <View
          style={{
            justifyContent: 'center',
            alignItems: 'center',
            height: 40,
          }}>
          <Text style={{fontSize: 18, textAlign: 'center', fontWeight: '400'}}>
            {warnMessage}
          </Text>
        </View>
        <LiveDetect
          style={{
            width: 250,
            height: 250,
            borderRadius: 125,
            overflow: 'hidden',
            backgroundColor: '#ffffff',
            justifyContent: 'center',
            alignItems: 'center',
          }}
          onActionChange={handleActionChange}
          onWarnChange={handleWarnChange}
          onStepChange={handleStepChange}
          onResultChange={handleResultChange}
        />
        <LiveDetectTip {...{tipMessage, actions, currentStep}} />
      </View>
      <Modal isVisible={visible}>
        <View
          style={{
            backgroundColor: 'white',
            padding: 20,
            justifyContent: 'center',
            alignItems: 'center',
          }}>
          <Text>{resultMessage}</Text>
          <Text>{token}</Text>
        </View>
      </Modal>
    </SafeAreaView>
  );
};

export default App;
